/**
 * 
 * @author ragya
 * @version 1.0
 * @since February 04, 2020
 */
public class Referee implements Constants{
	/**declaring xPlayer, oPlayer, and the board under the class of Referee */
	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	public void runTheGame() 
	{
		/** call to start the game starts here, firstly by setting the two players and calling the display func*/
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
		
	}
	/**
	 * setter functions connecting the ref to X player
	 * @param connect board to the referee*/
	public void setBoard(Board b) {board=b;}
	/**
	 * setter functions connecting the ref  O player,
	 * @param connect oPlayer to the referee*/
	public void setoPlayer(Player o) {oPlayer = o;}
	/**
	 * setter functions connecting the ref  X player,
	 * @param connect xPlayer to the referee*/
	public void setxPlayer(Player x) {xPlayer= x;}
	
}