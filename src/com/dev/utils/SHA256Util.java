package com.dev.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA256Util {
	
    public static String sha256(String msg){
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(msg.getBytes());
			return bytesToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
        
    }
	
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) {
          builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
