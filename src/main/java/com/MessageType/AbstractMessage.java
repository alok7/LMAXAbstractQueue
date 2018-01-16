package com.MessageType;

public abstract class AbstractMessage {
	private long timestamp;
	private String msgType;
	int val;
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public abstract int compute(int p);// specific implementation in derived class

}
