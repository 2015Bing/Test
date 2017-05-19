package com.bing.atomic.manager;

import java.util.concurrent.atomic.AtomicStampedReference;

import com.bing.atomic.bean.Data;

public class Reference {
	
	static AtomicStampedReference<Data> data=new AtomicStampedReference<Data>(null, 0);
	
	public AtomicStampedReference<Data> getAtomicData(){
		return data;
	}
	
	public void test(){
		
	}
}
