package com.bing.manager;
/**
 * @author TableMiao
 * @time 2013-7-2
 * @Description:Rsa加密，解密源码
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
  * 得到公钥和私钥
  * @throws Exception
  */
 public static void generateKey() throws Exception{
	  KeyPairGenerator gen = KeyPairGenerator.getInstance(RSA); 
	  gen.initialize(512, new SecureRandom()); 
	  KeyPair keyPair = gen.generateKeyPair(); 
	  uk = keyPair.getPublic();
	//  System.out.println("公钥"+uk);
	  rk = keyPair.getPrivate();
	//  System.out.println("si钥"+rk);
 }

 /**
  * 加密的子方法
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
  * 加密方法
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
  * 解密方法
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
  * 解密的子方法
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
  * 加密算法，给加密方法进行调用
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
  * 解密算法，给解密方法调用
  * @param b
  * @return
  */
 public static byte[] hex2byte(byte[] b){
	 
  if ((b.length % 2) != 0)
	  throw new IllegalArgumentException("长度不是偶数");
  	  byte[] b2 = new byte[b.length / 2];
	  for (int n = 0; n < b.length; n += 2){
	     String item = new String(b, n, 2);
	     b2[n/2] = (byte)Integer.parseInt(item, 16);
	  }
  return b2;
 }
 
}
