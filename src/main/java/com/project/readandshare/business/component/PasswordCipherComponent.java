package com.project.readandshare.business.component;

import com.project.readandshare.business.exception.ReadandshareException;

public interface PasswordCipherComponent {

	String encrypt(String plainPassword) throws ReadandshareException;
	
	String decrypt(String encryptedPassword) throws ReadandshareException;
	
}
