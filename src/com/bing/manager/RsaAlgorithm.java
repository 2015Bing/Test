package com.bing.manager;
/**
 * @author TableMiao
 * @time 2013-7-2
 * @Description:Rsa���ܣ�����Դ��
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;

public class RsaAlgorithm { 
	 private final static String RSA = "RSA";
	 public static PublicKey uk;
	 public static PrivateKey rk;
 
 /**
  * �õ���Կ��˽Կ
  * @throws Exception
  */
 public static void generateKey() throws Exception{
	  KeyPairGenerator gen = KeyPairGenerator.getInstance(RSA); 
	  gen.initialize(512, new SecureRandom()); 
	  KeyPair keyPair = gen.generateKeyPair(); 
	  uk = keyPair.getPublic();
	//  System.out.println("��Կ"+uk);
	  rk = keyPair.getPrivate();
	//  System.out.println("siԿ"+rk);
 }

 /**
  * ���ܵ��ӷ���
  * @param text
  * @param pubRSA
  * @return
  * @throws Exception
  */
 private static byte[] encrypt(String text, PublicKey pubRSA) throws Exception{
	  Cipher cipher = Cipher.getInstance(RSA); 
	  cipher.init(Cipher.ENCRYPT_MODE, pubRSA);
	  return cipher.doFinal(text.getBytes());
 }

 /***
  * ���ܷ���
  * @param text
  * @return
  */
 public final static String encrypt(String text){
	 try {
		   return byte2hex(encrypt(text, uk));
	 }catch(Exception e){
	   e.printStackTrace();
	  }
	  return null;
 }
 
 /**
  * ���ܷ���
  * @param data
  * @return
  */
 public final static String decrypt(String data){
	  try{
	     return new String(decrypt(hex2byte(data.getBytes())));
	  }catch (Exception e){
		   e.printStackTrace();
	  }
	  return null;
 }
 
 /**
  * ���ܵ��ӷ���
  * @param src
  * @return
  * @throws Exception
  */
 private static byte[] decrypt(byte[] src) throws Exception{
	  Cipher cipher = Cipher.getInstance(RSA);
	  cipher.init(Cipher.DECRYPT_MODE, rk);
	  return cipher.doFinal(src);
 } 
 
 /**
  * �����㷨�������ܷ������е���
  * @param b
  * @return
  */
 public static String byte2hex(byte[] b){
	 String hs = "";
	 String stmp = "";
  for (int n = 0; n < b.length; n ++){
	 stmp = Integer.toHexString(b[n] & 0xFF);
	 if (stmp.length() == 1)
	    hs += ("0" + stmp);
	 else
	    hs += stmp;
  }
    return hs.toUpperCase();
 }
 
 /**
  * �����㷨�������ܷ�������
  * @param b
  * @return
  */
 public static byte[] hex2byte(byte[] b){
	 
  if ((b.length % 2) != 0)
	  throw new IllegalArgumentException("���Ȳ���ż��");
  	  byte[] b2 = new byte[b.length / 2];
	  for (int n = 0; n < b.length; n += 2){
	     String item = new String(b, n, 2);
	     b2[n/2] = (byte)Integer.parseInt(item, 16);
	  }
  return b2;
 }
 
}
