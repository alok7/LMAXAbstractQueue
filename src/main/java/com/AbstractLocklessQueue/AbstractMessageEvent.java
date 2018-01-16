package com.AbstractLocklessQueue;

import com.MessageType.AbstractMessage;

public class AbstractMessageEvent {
	private String info;
	private AbstractMessage msg;
	public AbstractMessage getMsg() {
		return msg;
	}
	public void setMsg(AbstractMessage msg) {
		this.msg = msg;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
