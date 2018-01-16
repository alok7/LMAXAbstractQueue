package com.AbstractLocklessQueue;

import com.MessageType.AbstractMessage;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.EventTranslatorTwoArg;

public class AbstractMessageEventProducer implements EventTranslatorOneArg<AbstractMessageEvent, AbstractMessage>
             , EventTranslatorTwoArg<AbstractMessageEvent, AbstractMessage, String>{
	
	private int ct = 0;
	
	@Override
	public void translateTo(AbstractMessageEvent event, long sequence, AbstractMessage msg) {
		event.setMsg(msg);
		ct++;
	}
	@Override
	public void translateTo(AbstractMessageEvent event, long sequence, AbstractMessage msg, String info) {
		event.setMsg(msg);
		event.setInfo(info);
		ct++;
	}
}
