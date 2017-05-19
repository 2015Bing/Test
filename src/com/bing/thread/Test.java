package com.bing.thread;

public class Test implements MyCall<Data>{
	
	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(new MyThread());
		thread.start();
		for(int i=0;i<100000;i++){
			System.out.println("Main=="+i);
		}
	}

	@Override
	public void getCall(Data data) {
		System.out.println("CallBack==============================子线程执行完毕");
	}

}
