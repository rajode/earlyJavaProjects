/**
 * @Author Ragya Mittal
 * @version 1.0
 * @since February 04, 2020
  */
/** class Player- contains the information about the player as well as the methods assigned in the post lab*/

import java.util.Scanner;
public abstract class Player implements Constants{
	/** The name of the player*/
	protected String name;
	/** declaring the board*/
	protected Board board;
	/** The opponent Player of class Player*/
	protected Player opponent;
	/** mark of X or O for the game*/
	protected char mark;
	
	protected abstract void play();
	protected abstract void makeMove(); 
	
	/**
	 *  constructor for player
	 *  @param name the player 
	 *  @param the assigned mark of the player
	 */
	public Player(String s, char c) {
		name= s; 
		mark= c; 
	}
	
	
	
	/**
	 *  setter function to connect opponent to player
	 *  @param assign opponent player to player
	 */
	protected void setOpponent(Player opponent_player) {opponent =opponent_player;}
	
	/**
	 * setter function to connect board to player
	 * @param assign board to the player
	 */
	protected void setBoard(Board nameofboard) {board= nameofboard;}
}