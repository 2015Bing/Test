package com.bing.atomic;

import com.bing.atomic.manager.Reference;

public class ConsumerThread implements Runnable{
	
	private Reference reference = null;
	
	public ConsumerThread(){
		this.reference=new Reference();
	}

	@Override
	public void run() {
		
	}

}
