package com.customexceptions;

/**
 * Custom exception for when input files are not in the expected format
 * @author Evan
 */
public class ImproperFileContentException extends Exception{
	
	/**
	 * The no-arguments constructor.
	 */
	public ImproperFileContentException() {}; 
	
	/**
	 * A constructor that accepts a related message.
	 * @param msg The message to store in the exception object
	 */
	public ImproperFileContentException(String msg) {
		super(msg);
	}
}
