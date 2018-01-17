**A lockless queue for publishing "abstract-type" messages using LMAX Disruptor** 

*We can't instantiate constructor for abstract type messages. LMAX Disruptor requires a factory design to instantiate instances of messages before the onset of Disruptor itself. There are situations when we don't know the exact message type, which we shall be queueing, except that its abstract type which can't be instantiated. This API shows how to implement LMAX queue for generic-abstract type messages.*  
