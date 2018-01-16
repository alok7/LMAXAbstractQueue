package com.AbstractLocklessQueue;

import com.lmax.disruptor.EventFactory;

public class AbstractMessageEventFactory implements EventFactory<AbstractMessageEvent>{

	@Override
	public AbstractMessageEvent newInstance() {
		
		return new AbstractMessageEvent();
	}

}
