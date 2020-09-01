消费者优先级
Disruptor 可以做到的事情远远不止上面的内容。在实际场景中，我们通常会因为业务逻辑而形成一条消费链。比如一个消息必须由 消费者A -> 消费者B -> 消费者C 的顺序依次进行消费。在配置消费者时，可以通过 .then 方法去实现。如下：
```
disruptor.handleEventsWith(new OrderEventHandler())
         .then(new OrderEventHandler())
         .then(new OrderEventHandler());
```
当然，handleEventsWith 与 handleEventsWithWorkerPool 都是支持 .then 的，它们可以结合使用。比如可以按照 消费者A -> (消费者B 消费者C) -> 消费者D 的消费顺序
```
disruptor.handleEventsWith(new OrderEventHandler())
         .thenHandleEventsWithWorkerPool(new OrderEventHandler(), new OrderEventHandler())
         .then(new OrderEventHandler());
```

其实 生成者 -> 消费者 模式是很常见的，通过一些消息队列也可以轻松做到上述的效果。不同的地方在于，Disruptor 是在内存中以队列的方式去实现的，而且是无锁的。这也是 Disruptor 为什么高效的原因。

