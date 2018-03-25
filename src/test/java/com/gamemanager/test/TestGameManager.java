package com.gamemanager.test;

import static org.junit.Assert.*;

import org.testng.annotations.Test;

/**
 * Unit Tests for the GameManager class. 
 * 
 * Note: The constructors cannot be tested without using the getBoard() function. 
 * @author Evan
 *
 */
public class TestGameManager {
	
	
	//To-Do: Research commenting practices for Unit Functions
	/**
	 * Unit Test for the <code>getBoard</code> function. 
	 * 
	 * Ensures that a deep copy of the board from the <code>GameManager</code> instance
	 * is returned.
	 */
	@Test
	public void testGetBoard() {
		fail("Not yet implemented");
	}
	
	/**
	 * Unit Test for the 
	 */
	@Test
	public void testReadAndParseAndCheckFile() {
		fail("Not yet implemented");
	}
	
	//Set dependancy for this test to the testGetBoard() and testReadAndParseAndCheckFile() tests
	/**
	 * Unit Test for the no-arguments constructor.
	 * 
	 * Ensures that the default file is read and interpreted properly.
	 */
	@Test
	public void testNoArgsConstructor() {
		fail("Not yet implemented");
	}
	
	/**
	 * Unit Test for the constructor that takes a filename.
	 * 
	 * Ensures that the a custom board state can be read and stored. 
	 * Also ensures that exceptions are thrown on files that don't exist
	 * and on files with invalid content. 
	 */
	@Test
	public void testFilenameConstructor() {
		fail("Not yet implemented");
	}
	
	//ToDo: Test Driven Development -> Write tests for the rest of the GameManager functionality
}
