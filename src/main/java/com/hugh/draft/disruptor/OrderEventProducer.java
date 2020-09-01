package com.hugh.draft.disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/1 9:50 上午
 * @Version 1.0
 **/
public class OrderEventProducer {

    private final RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(String orderId) {
        long sequence = ringBuffer.next();
        try {
            OrderEvent orderEvent = ringBuffer.get(sequence);
            orderEvent.setId(orderId);
        } finally {
            ringBuffer.publish(sequence);
        }
    }

}