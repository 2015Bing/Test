package com.bing.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

import com.bing.atomic.bean.Data;
import com.bing.atomic.manager.Reference;

public class ProducerThread implements Runnable {

	private Reference reference = null;
	
	public ProducerThread(){
		this.reference=new Reference();
	}
	
	@Override
	public void run() {
		Data data=null;
		int timestamp=(int) Thread.currentThread().getId();
		AtomicStampedReference<Data> atomicData=reference.getAtomicData();
		while(true){
			while(true){
				timestamp=atomicData.getStamp();
				data=atomicData.getReference();
				data.setName("小明");
				atomicData.compareAndSet(data, data, timestamp, timestamp+1);
			}
			
		}
	}

}
