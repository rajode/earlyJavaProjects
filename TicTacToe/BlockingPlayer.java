
public class BlockingPlayer extends RandomPlayer implements Constants{

	public BlockingPlayer(String s, char c) {
		super(s, c);
		// TODO Auto-generated constructor stub
	}
	protected void makeMove()
	{
		int i,j;
	
		for(i=0; i<3; i++) 
		{
			for(j=0; j<3; j++) 
			{
				if(testForBlocking(i,j) == true) {
					board.addMark(i, j, mark);
					return;}
			}
		}
		super.makeMove();
	}

	protected boolean testForBlocking(int row, int col)
	{
		int hor=0;
		int ver=0;
		int backslash=0;
		int frontslash=0;
		if(board.getMark(row, col) != SPACE_CHAR)
			return false;
		
		for(int i=0; i<3; i++) {
		if(board.getMark(row, i)== opponent.mark)
				hor++;}
		
		for(int i=0; i<3; i++) {
			if(board.getMark(i, col)== opponent.mark)
					ver++;}
		if(row == col){
		for(int i=0; i<3; i++) {
			if(board.getMark(i, i)== opponent.mark)
					backslash++;}}
		if(row== (2-col)){
		int j=2;
		for(row=0; j>=0; j--) {
			if(board.getMark(row, j)== opponent.mark) {
				frontslash++;}
			row++;
			}}
		
		if(hor==2|| ver==2 || backslash==2|| frontslash==2 )
			return true;
		
		return false;
		
	}
}
