package com.bing.manager;
/**
 * @author TableMiao
 * @time 2013-7-2
 * @Description:RSA测试
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RsaAlgorithm rsa = new RsaAlgorithm();
		try {
			//初始化公钥和私钥
			rsa.generateKey();
			String abc = rsa.encrypt("ABC");
			System.out.println("加密之后："+abc);
			String ABC = rsa.decrypt(abc);
			System.out.println("解密之后："+ABC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
