package com.customexceptions;

/**
 * Custom exception for when input files are not in the expected format
 * @author Evan
 */
public class ImproperFileContentException extends Exception{
	
	/**
	 * No Arguments constructor
	 */
	public ImproperFileContentException() {}; 
	
	/**
	 * Constructor that accepts a related message
	 * @param msg String containing message to store
	 */
	public ImproperFileContentException(String msg) {
		super(msg);
	}
}
