package com.gamemanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.customexceptions.ImproperFileContentException;

public class GameManager {
	/**
	 * Contains the row size of the chess board, abstracted just in case.
	 */
	private static int ROW_SIZE = 8;
	
	/**
	 * Contains the column size of the chess board, abstracted just in case.
	 */
	private static int COL_SIZE = 8;
	
	/**
	 * Defines the default file from which to initialize the board.
	 */
	private static String DEFAULT_BOARD_FILE = "defaultboard.txt";
	
	/**
	 * Stores the current state of the board using a 1D character array to facilitate deep copies of the array.
	 * Use a character array rather than a string array to better enforce input file constraints.
	 */
	private char[] board = null;
	
	/**
	 * The no-argument constructor for initializing a new game board from the default file.
	 * @throws ImproperFileContentException When the input file is in improper format.
	 * @throws IOException When the input file could not be opened.
	 */
	public GameManager() throws ImproperFileContentException, IOException{
		this.board = readAndParseAndCheckFile(DEFAULT_BOARD_FILE);
	}
	
	/**
	 * A constructor allowing the user to specify a custom file from which to initialize the chess board.
	 * @param filename Contains the filename to read.
	 * @throws ImproperFileContentException When the input file is in improper format.
	 * @throws IOException When the input file could not be opened.
	 */
	public GameManager(String filename) throws ImproperFileContentException, IOException {
		this.board = readAndParseAndCheckFile(filename);
	}
	
	/**
	 * Read and parse the input file. Check for problems with the content while doing so.
	 * 
	 * Input File Constraints:
	 * Input files must contain only the following characters: r, n, b, k, q, p, #.
	 * Those letters stand for the following chess pieces (in order): Rook, Knight, Bishob, King, Queen, Pawn.
	 * The # represents empty spaces on the board.
	 * A file must contain only 8 lines and each line can contain only 8 characters
	 * (i.e. a chess board is 8 by 8).
	 * 
	 * @param filename - Holds the name of the file to read.
	 * @return Returns a 2D character array of the game board read from the file.
	 * @throws ImproperFileContentException When the input file is in improper format.
	 * @throws IOException When the input file could not be opened.
	 */
	private char[] readAndParseAndCheckFile(String filename) throws ImproperFileContentException, IOException {
		FileReader fr = new FileReader(DEFAULT_BOARD_FILE);
		BufferedReader br = new BufferedReader(fr);
		List<String> file_lines = new ArrayList<String>();
		
		//Read each line of the file
		String line;		
		while( (line = br.readLine()) != null) {
			//There must be exactly 8 characters to a line
			//And the file can contain only the specified characters
			if(line.length() > COL_SIZE || line.length() < COL_SIZE ||
					!line.matches("rnbkqp#")) {
				throw new ImproperFileContentException();
			}
			file_lines.add(line);
		}
		//There must be exactly 8 lines in the file
		if(file_lines.size() > ROW_SIZE || file_lines.size() < ROW_SIZE) {
			throw new ImproperFileContentException();
		}
		
		//Convert the 2D String array to a 1D character array
		char[] board = new char[ROW_SIZE*COL_SIZE]; 
		for(int row = 0; row<ROW_SIZE; row++) {
			char [] temp = file_lines.get(row).toCharArray();
			for(int col = 0; col<COL_SIZE; col++) {
				board[row * ROW_SIZE + col] = temp[col]; 
			}
		}
		
		return board;
	}
	
	/**
	 * Returns a deep copy of the board.
	 * @return A 1D array containing the current state of the chess board.
	 */
	public char[] getBoard() {
		return Arrays.copyOf(board, (ROW_SIZE*COL_SIZE)); 
	}
}
