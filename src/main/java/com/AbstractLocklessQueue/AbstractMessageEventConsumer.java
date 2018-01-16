package com.AbstractLocklessQueue;

import com.MessageType.AbstractMessage;
import com.lmax.disruptor.EventHandler;

public class AbstractMessageEventConsumer implements EventHandler<AbstractMessageEvent>{
	private String consumer = null;
	public AbstractMessageEventConsumer(String consumer) {
		this.consumer = consumer;
	}
	@Override
	public void onEvent(AbstractMessageEvent event, long sequence, boolean endOfBatch) {
		/**
		 * Process/Modify... this event and it gets passed to another consumer, if waiting on dependencies graph  
		 * */
		System.out.println(
				 new StringBuilder("Consumer, ")
				.append(this.consumer)
				.append(" consuming message, ").append(event.getInfo()).toString()
		);
		
		this.consumeMessage(event.getMsg());
		
	}
	private void consumeMessage(AbstractMessage msg) {
		
	}

}
