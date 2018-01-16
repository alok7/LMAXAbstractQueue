package com.AbstractLocklessQueue;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class AbstractEventRingbuffer {
	// Executor that will be used to construct new threads for consumers
    private Executor executor = Executors.newCachedThreadPool();
    int bufferSize = 32768; // power of two
    AbstractMessageEventFactory factory = new AbstractMessageEventFactory();
    Disruptor<AbstractMessageEvent> disruptor = null;
    
    private AbstractEventRingbuffer(int bufferSize) {
    	/**
    	 * Override the default bufferSize 
    	 * */
    	this.bufferSize = bufferSize;
    	/**
    	 * Try YieldingWaitStrategy as well?  
    	 * */
    	this.disruptor = new Disruptor<AbstractMessageEvent>( 
    						factory, bufferSize, executor, ProducerType.SINGLE, new BusySpinWaitStrategy() 
    					 );
    	this.registerConsumers();
    	disruptor.start();
    }
    public static AbstractEventRingbuffer startDisruptor(int bufferSize) {
    	return new AbstractEventRingbuffer(bufferSize);
    }
    public RingBuffer<AbstractMessageEvent> getRingbuffer(){
    	return this.disruptor.getRingBuffer();
    }
    /**
     * Define consumers here, and their dependency graph
     * An implemented example with three consumers and their dependencies among them
     * */
    public void registerConsumers() { 
    	AbstractMessageEventConsumer ron = new AbstractMessageEventConsumer("Ron"),
    			                     shyam = new AbstractMessageEventConsumer("Shyam"),
    			                     mohan = new AbstractMessageEventConsumer("Mohan");
    	/**
    	 * ron, shyam consume parallel, and mohan after they are done 
    	 * */ 
    	disruptor.handleEventsWith(ron, shyam).then(mohan);
	}
}
