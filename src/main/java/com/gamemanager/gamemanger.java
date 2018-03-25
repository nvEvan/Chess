package com.gamemanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.customexceptions.ImproperFileContentException;

public class gamemanger {
	private static int ROW_SIZE = 8;
	private static int COL_SIZE = 8;
	private static String DEFAULT_BOARD_FILE = "defaultboard.txt";
	
	/**
	 * contains the current state of the chess board
	 */
	private char[][] board = null;
	
	/**
	 * No Argument constructor for initializing a new game board
	 * @throws ImproperFileContentException When the input file is in improper format. 
	 * @throws IOException When the input file could not be opened
	 */
	public gamemanger() throws ImproperFileContentException, IOException{
		this.board = readAndParseAndCheckFile(DEFAULT_BOARD_FILE);
	}
	
	/**
	 * Constructor with parameter for custom filename
	 * @param filename Contains the filename to read
	 * @throws ImproperFileContentException When the input file is in improper format
	 * @throws IOException When the input file could not be opened
	 */
	public gamemanger(String filename) throws ImproperFileContentException, IOException {
		this.board = readAndParseAndCheckFile(filename);
	}
	
	/**
	 * Read and parse the input file. Check for problems with the content while doing so
	 * @param filename - String containing filename to read
	 * @return Returns a 2D character array of the game board read from the file
	 * @throws ImproperFileContentException When the input file is in improper format
	 * @throws IOException When the input file could not be opened
	 */
	private char[][] readAndParseAndCheckFile(String filename) throws ImproperFileContentException, IOException {
		FileReader fr = new FileReader(DEFAULT_BOARD_FILE);
		BufferedReader br = new BufferedReader(fr);
		List<String> file_lines = new ArrayList<String>();
		
		//Read each line of the file
		String line;		
		while( (line = br.readLine()) != null) {
			//Throw exception if the number of columns is not as expected
			//    or if the file contains unexpected characters.
			if(line.length() > COL_SIZE || line.length() < COL_SIZE ||
					!line.matches("rnbkqp#")) {
				throw new ImproperFileContentException();
			}
			file_lines.add(line);
		}
		//Throw exception if the number of rows is not as expected
		if(file_lines.size() > ROW_SIZE || file_lines.size() < ROW_SIZE) {
			throw new ImproperFileContentException();
		}
		
		char[][] board = new char[ROW_SIZE][]; 
		for(int row = 0; row<ROW_SIZE; row++) {
			board[row] = file_lines.get(row).toCharArray();
		}
		
		return board;
	}
}
