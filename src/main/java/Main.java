import java.util.Scanner;

import com.inf5153.game.ConnectFour;


public class Main {
	private static final char[] PLAYERS = {'R', 'Y'};
	public static void main(String[] args) {
	    // we assemble all the pieces of the puzzle for 
	    // building our Connect Four Game
	    try (Scanner input = new Scanner(System.in)) {
	      // we define some variables for our game like 
	      // dimensions and nb max of moves
	      int height = 6; int width = 8; int moves = height * width;

	      // we create the ConnectFour instance
	      ConnectFour board = new ConnectFour(width, height);

	      // we explain users how to enter their choices
	      System.out.println("Use 0-" + (width - 1) + " to choose a column");
	      // we display initial board
	      System.out.println(board);

	      // we iterate until max nb moves be reached
	      // simple trick to change player turn at each iteration
	      for (int player = 0; moves-- > 0; player = 1 - player) {
	        // symbol for current player
	        char symbol = PLAYERS[player];

	        // we ask user to choose a column
	        board.chooseAndDrop(symbol, input);

	        // we display the board
	        System.out.println(board);

	        // we need to check if a player won. If not, 
	        // we continue, otherwise, we display a message
	        if (board.isWinningPlay()) {
	          System.out.println("\nPlayer " + symbol + " wins!");
	          return;
	        }
	      }
	    
	      System.out.println("Game over. No winner. Try again!");
	    }
	  }
 
}