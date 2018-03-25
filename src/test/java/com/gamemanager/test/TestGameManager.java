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
	
	/**
	 * Unit Test for the <code>getBoard</code> function. 
	 * 
	 * Ensures that a deep copy of the <code>GameManager</code> object's board 
	 * is returned.
	 */
	@Test
	public void testGetBoard() {
		
	}
	
	//Set dependancy for this test to the testGetBoard() test
	/**
	 * Unit Test for the no-arguments constructor
	 */
	@Test
	public void testNoArgsConstructor() {
		fail("Not yet implemented");
	}
	
	/**
	 * Unit Test for the constructor taking a filename
	 */
	@Test
	public void testFilenameConstructor() {
		fail("Not yet implemented");
	}
}
