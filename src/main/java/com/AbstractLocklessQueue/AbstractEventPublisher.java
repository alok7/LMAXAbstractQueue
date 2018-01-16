package com.AbstractLocklessQueue;

import com.MessageType.AbstractMessage;
import com.lmax.disruptor.RingBuffer;

public class AbstractEventPublisher {
	
	private RingBuffer<AbstractMessageEvent> ringbuffer= null;
	private int bufferSize = 32768;
	AbstractMessageEventProducer producer = new AbstractMessageEventProducer();
	
	private AbstractEventPublisher() {
		ringbuffer = AbstractEventRingbuffer.startDisruptor(bufferSize).getRingbuffer();
	}
	public void publishEventToLocklessQueue(AbstractMessage message, String someOtherInfo) {
		ringbuffer.publishEvent(producer, message, someOtherInfo);
		
	}
	public void publishEventToLocklessQueue(AbstractMessage message) {
		ringbuffer.publishEvent(producer, message);
		
	}
	public static AbstractEventPublisher getAbstractTypeImplementedDisruptorQueue() {
		return new AbstractEventPublisher();
	}
}
