package com.bing.manager;
/**
 * @author TableMiao
 * @time 2013-7-2
 * @Description:RSA����
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RsaAlgorithm rsa = new RsaAlgorithm();
		try {
			//��ʼ����Կ��˽Կ
			rsa.generateKey();
			String abc = rsa.encrypt("ABC");
			System.out.println("����֮��"+abc);
			String ABC = rsa.decrypt(abc);
			System.out.println("����֮��"+ABC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
