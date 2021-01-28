import java.util.Scanner;

public class RandomPlayer extends Player implements Constants{

	public RandomPlayer(String s, char c) {
		super(s, c);
		// TODO Auto-generated constructor stub
	}
	protected void play() 
	{
		/**runs the game as long as a player has won or 9 moves have been played*/
		while(!(board.xWins()) && !(board.oWins()) && !(board.isFull())) 
		{
			makeMove();
			
			board.display();
			if(board.xWins())
			{
				
				System.out.printf("%10s WINS!!!", name);
				break;
			}
			else if(board.isFull())
			{
				System.out.printf("GAME ENDED IN A TIE");
				break;
			}
			opponent.makeMove();
			board.display();
			if(board.oWins())
			{
				
				System.out.printf("%10s WINS!!!", opponent.name);
				break;
			}
			else if(board.isFull())
			{
				System.out.printf("GAME ENDED IN A TIE");
				break;
			}
		}
	}
	protected void makeMove()
	{
		/**asks the player to make a move by entering the row and column numbers, and puts a 
		‘X’ or ‘O’ mark on the board, by calling method addMark in class Board.*/
		RandomGenerator x= new RandomGenerator();
		int row, col;
		do {
		row= x.discrete(0,2);
		col= x.discrete(0,2);
			
		}while((board.getTheBoard())[row][col] != SPACE_CHAR);
			
			board.addMark(row, col, mark);
				
	}

}
