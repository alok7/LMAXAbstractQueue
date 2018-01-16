package com.MessageType;

public class TradeOrderMessage extends AbstractMessage{
	
	private long orderSize; // some specific attributes for Order Message 
	
	@Override
	public int compute(int p) {
		// do some specific computation for this message 
		return val;
	}
	public long getOrderSize() {
		return orderSize;
	}
	public void setOrderSize(long orderSize) {
		this.orderSize = orderSize;
	}
}
