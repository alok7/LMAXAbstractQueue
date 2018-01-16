package com.MessageType;

public class TradeQuoteMessage extends AbstractMessage{
	
	private int feedId;
	@Override
	public int compute(int p) {
		// do some specific computation for this message 
		return val;	
	}
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
}
