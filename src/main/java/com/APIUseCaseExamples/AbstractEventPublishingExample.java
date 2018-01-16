package com.APIUseCaseExamples;

import com.AbstractLocklessQueue.AbstractEventPublisher;
import com.MessageType.AbstractMessage;
import com.MessageType.TradeOrderMessage;
import com.MessageType.TradeQuoteMessage;
/**
 * Using the abstract-type implemented messages to publish into the disruptor queue 
 * */
public class AbstractEventPublishingExample {
	
	public static void main(String[] args) {
		
		AbstractEventPublisher disruptorQueue = AbstractEventPublisher.getAbstractTypeImplementedDisruptorQueue();
		for(int id = 1; id <= 10; id++) {   
			AbstractMessage msg = new TradeOrderMessage();
			msg.setTimestamp(System.nanoTime());
			msg.setMsgType("Order Message");
			((TradeOrderMessage) msg).setOrderSize(1000*id);
			disruptorQueue.publishEventToLocklessQueue(msg);
		}
		for(int id = 1; id <= 10; id++) {  
			AbstractMessage msg = new TradeQuoteMessage();
			msg.setTimestamp(System.nanoTime());
			msg.setMsgType("Trade Message");
			((TradeQuoteMessage) msg).setFeedId(1);
			disruptorQueue.publishEventToLocklessQueue(msg);
		}
	}
}
