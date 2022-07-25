package com.cg.school.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{	
	public UserNotFoundException(String message) {
        super(message);
    }
}