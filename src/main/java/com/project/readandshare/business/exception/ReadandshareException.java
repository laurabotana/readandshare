package com.project.readandshare.business.exception;

public class ReadandshareException extends Exception {

	private static final long serialVersionUID = -9187444001502620213L;

	public ReadandshareException(String message) {
		super(message);
	}
	
    public ReadandshareException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
