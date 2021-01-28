

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/**this class contains the logic of the game, and the actual board display itself*/
public class Board implements Constants {
	/** the board matrix that holds the players' X or O input*/
	private char theBoard[][];
	
	/** keeps count of the player moves (marks)*/
	private int markCount;
	

	public Board() {
		/** create empty board*/
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * 
	 * @param row
	 * @param col
	 * @return char
	 */
	public char getMark(int row, int col) {
		/** returns the mark (x or o) of the given row, col coordinate*/
		return theBoard[row][col];
	}

	/**
	 * 
	 * @return true if 9th turn reached
	 */
	public boolean isFull() {
		/** returns true if 9 marks done*/
		return markCount == 9;
	}

	/**
	 * 
	 * @return true if x player wins according to checkWinner function
	 */
	public boolean xWins() {
		/** checks for x's winning condition*/
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @return true if O player wins according to checkWinner function
	 */
	public boolean oWins() {
		/** checks for o's winning condition*/
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/** this prints out the actual board for the game*/
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}
	
	/**
	 * 
	 * @param row index for where to place mark
	 * @param col index for where to place mark
	 * @param type of (char) mark to place on the board
	 */
	public void addMark(int row, int col, char mark) {
		/** adds mark for xplayer or oplayer, also increments the turn*/
		theBoard[row][col] = mark;
		markCount++;
	}
/** resets the board, clearing it, and setting turn count to 0*/
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * 
	 * @param mark (X or O)
	 * @return 1 if the char provided has won
	 */
	int checkWinner(char mark) {
		/** this function determines if a player has won (vertically, horizontally, or diagonally*/
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
	
/** below are the helper functions for the display() function*/
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
	public char[][] getTheBoard(){return theBoard;}
}
