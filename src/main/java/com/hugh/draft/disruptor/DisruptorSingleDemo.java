package com.hugh.draft.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/1 10:05 上午
 * @Version 1.0
 **/
@Slf4j
public class DisruptorSingleDemo {
    public static void main(String[] args) throws InterruptedException {

        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                // Java 8 中我们可以通过 `::` 关键字来访问类的构造方法，对象方法，静态方法
                OrderEvent::new,
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );

        // 加载Handler  多消费者
        disruptor.handleEventsWith(new OrderEventHandler(), new OrderEventHandler());
        // 多消费者轮询
        disruptor.handleEventsWithWorkerPool(new OrderEventHandler(), new OrderEventHandler());

        // 开始消费
        disruptor.start();

        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        // 新建生产者
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);

        eventProducer.onData(UUID.randomUUID().toString());
    }
}
