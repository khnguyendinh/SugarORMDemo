package jsc.com.lampstudio.until;/*
 * Created on Apr 12, 2016
 *
 * Copyright (C) 2016 by Viettel Network Company. All rights reserved
 */



import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;


/**
 * until.PasswordEncoder.java
 *
 * @author Nguyen Hai Ha (hanh45@viettel.com.vn)
 * @since Apr 12, 2016
 * @version 1.0.0
 */
public class PasswordEncoder {
	//	private static final Logger logger = LoggerFactory.getLogger(until.PasswordEncoder.class);
//	private static final char[] PASSWORD = "d4ebaae0-e44f-11e2-a28f-0800200c9a66".toCharArray();
	private static final char[] PASSWORD2= "ngoan970400".toCharArray();
	private static final byte[] SALT = { (byte) 0xba, (byte) 0x96, (byte) 0x57, (byte) 0x14, (byte) 0xef, (byte) 0xd4, (byte) 0x20, (byte) 0xf1 };
	PasswordEncoder instance;
	public PasswordEncoder getInstance() {
		if(instance == null){
			instance = new PasswordEncoder();
		}
		return instance;
	}

	public static String encrypt(String property){
		String encrypt = "";
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD2));
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			encrypt = base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
		} catch (GeneralSecurityException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return encrypt;
	}

	public static String encryptUrlParam(String property) {
		String encrypt = "";
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD2));
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			encrypt = base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
			encrypt = encrypt.replace('+', '-').replace('/', '_').replace("%", "%25").replace("\n", "%0A");
		} catch (GeneralSecurityException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return encrypt;
	}

	private static String base64Encode(byte[] bytes) {
		byte[] encodedBytes = Base64.encode(bytes,1);
		return new String(encodedBytes);
	}

	public static String decrypt(String property){
		String decrypt = property;
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD2));
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			decrypt = new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
		} catch (GeneralSecurityException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return decrypt;
	}

	public static String decryptUrlParam(String property){
		String decrypt = "";
		try {
			property = property.replace("%0A", "\n").replace("%25", "%").replace('_', '/').replace('-', '+');
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD2));
			Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
			pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
			decrypt = new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
		} catch (GeneralSecurityException | UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return decrypt;
	}

	private static byte[] base64Decode(String property) throws IOException {
		byte[] decodedBytes = Base64.decode(property,1);
		return decodedBytes;
	}
}
