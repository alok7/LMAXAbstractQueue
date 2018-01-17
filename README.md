**A lockless queue for publishing implementations of "abstract-type" messages using LMAX Disruptor** 
We can't instantiate constructor for abstract/generic type messages. LMAX Disruptor requires a factory method which instantiates a buffer of new instances of messages at the start of Disruptor itself. This API shows how to implement LMAX queue for generic-abstract type messages.  
