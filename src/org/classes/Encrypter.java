package org.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;

public class Encrypter {
  private KeySpec keySpec;
  private SecretKey key;
  private IvParameterSpec iv;
  
  public Encrypter(String keyString) {
    try {
      final MessageDigest md = MessageDigest.getInstance("md5");
      final byte[] digestOfPassword = md.digest(Base64.decodeBase64(keyString.getBytes("utf-8")));
      final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
      for (int j = 0, k = 16; j < 8;) {
        keyBytes[k++] = keyBytes[j++];
      }
      
      keySpec = new DESedeKeySpec(keyBytes);
      
      key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
      
      iv = new IvParameterSpec(new byte[8]);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public String encrypt(String value) {
    try {
      Cipher ecipher = Cipher.getInstance("DESede/CBC/PKCS5Padding","SunJCE");
      ecipher.init(Cipher.ENCRYPT_MODE, key, iv);
      
      if(value==null)
        return null;
      
      // Encode the string into bytes using utf-8
      byte[] utf8 = value.getBytes("UTF8");
      
      // Encrypt
      byte[] enc = ecipher.doFinal(utf8);
      
      // Encode bytes to base64 to get a string
      return new String(Base64.encodeBase64(enc),"UTF-8");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public String decrypt(String value) {
    try {
      Cipher dcipher = Cipher.getInstance("DESede/CBC/PKCS5Padding","SunJCE");
      dcipher.init(Cipher.DECRYPT_MODE, key, iv);
      
      if(value==null)
        return null;
      
      // Decode base64 to get bytes
      byte[] dec = Base64.decodeBase64(value.getBytes());
      
      // Decrypt
      byte[] utf8 = dcipher.doFinal(dec);
      
      // Decode using utf-8
      return new String(utf8, "UTF8");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static void main(String arg[]) throws FileNotFoundException {
	  String keyString=null;
	  FileReader f = new FileReader("resources/key/key.asc"); 
	  BufferedReader b = new BufferedReader(f);      
	  try {
		keyString = b.readLine();
		b.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
    Encrypter encrypter = new Encrypter(keyString);
	System.out.println(encrypter.encrypt("esta es una prueba"));
	System.out.println(encrypter.decrypt("MIpLYnaZ3SLbQwBdqgF5eRnSDzj9nzic"));
	
  	}
  
  
} 