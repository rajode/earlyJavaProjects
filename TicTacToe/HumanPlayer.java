import java.util.Scanner;

public class HumanPlayer extends Player{

	public HumanPlayer(String s, char c) {
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
			Scanner input = new Scanner(System.in);
			System.out.printf("\n%10s, what row should your next %1s be placed in?", name, mark);
			int row= input.nextInt();
			if(row>2 || row<0) {
				System.out.printf("\nInvalid row... EXITTING");
			return;
			}
			
			System.out.printf("\n%10s, what column should your next %1s be placed in?", name, mark);
			int col= input.nextInt();
			if(col>2 || col < 0) {
				System.out.printf("\nInvalid col... EXITTING");
				return;
			}
			board.addMark(row, col, mark);
				
	}
}
