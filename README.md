**A lockless queue for publishing "abstract-type" messages using LMAX Disruptor** 

*We can't instantiate abstract type messages. LMAX Disruptor requires a factory design to construct message instances. There are situations, we don't know the exact message type, which we shall be queueing, except that it's type which is abstract. This API shows how to implement LMAX queue for generic-abstract type messages.*  
