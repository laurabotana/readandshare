package com.project.readandshare.business.component.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.project.readandshare.business.component.PasswordCipherComponent;
import com.project.readandshare.business.exception.ReadandshareException;

@Component(PasswordCipherComponentImpl.ID)
public class PasswordCipherComponentImpl implements PasswordCipherComponent {

	public static final String ID = "passwordCipherComponentImpl";
	
	private final Log LOGGER = LogFactory.getLog(getClass());
	
	private static final String TYPE_ENCRYPTION = "AES";
	
	private SecretKeySpec generateMySQLKey(final String key, final String encoding) throws ReadandshareException {
		SecretKeySpec secretKey = null;
		try {
			final byte[] finalKey = new byte[16];
			int i = 0;
			for(byte b : key.getBytes(encoding))
				finalKey[i++%16] ^= b;
			secretKey = new SecretKeySpec(finalKey, TYPE_ENCRYPTION);
		} 
		catch(UnsupportedEncodingException e) {
			String message = "Se ha producido un error al codificar la password";
			LOGGER.error(message, e);
			throw new ReadandshareException(message, e);
		}
		return secretKey;
	}
	
	@Override
	public String encrypt(String plainPassword) throws ReadandshareException {
		String encryptedPassword = null;
		try {
			Cipher encryptCipher = Cipher.getInstance(TYPE_ENCRYPTION);
			encryptCipher.init(Cipher.ENCRYPT_MODE, generateMySQLKey("clave", "UTF-8"));
			encryptedPassword = new String(Hex.encodeHex(encryptCipher.doFinal(plainPassword.getBytes("UTF-8"))));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
				IllegalBlockSizeException | BadPaddingException |
				UnsupportedEncodingException e) {
			String message = "Se ha producido un error al cifrar la password";
			LOGGER.error(message, e);
			throw new ReadandshareException(message, e);
		}
		return encryptedPassword;
	}

	@Override
	public String decrypt(String encryptedPassword) throws ReadandshareException {
		String plainPassword = null;
		try {
			Cipher decryptCipher;
			decryptCipher = Cipher.getInstance(TYPE_ENCRYPTION);
			decryptCipher.init(Cipher.DECRYPT_MODE, generateMySQLKey("clave", "UTF-8"));
			plainPassword = new String(decryptCipher.doFinal(Hex.decodeHex(encryptedPassword.toCharArray())));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | DecoderException e) {
			String message = "Se ha producido un error al descifrar la password";
			LOGGER.error(message, e);
			throw new ReadandshareException(message, e);
		}
		return plainPassword;
	}

}
