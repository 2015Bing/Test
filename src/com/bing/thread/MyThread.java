package com.bing.thread;

public class MyThread implements Runnable{
	
	private Test test=null;
	
	public MyThread(){
		test=new Test();
	}

	@Override
	public void run() {
		try {
			System.out.println("================================RUNNING=====================");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			test.getCall(new Data());
		}
	}
	
	
}
