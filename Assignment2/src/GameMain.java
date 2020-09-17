import java.util.Scanner;				// Scanner required for player input

public class GameMain {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input
	
	private Grid grid;					// The game board
	private boolean gameOver;			// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player 
 
 
   public GameMain() {				//Constructor: Creates the grid and sets the values of the variables before calling the play method.

	   grid = new Grid();			// Create the grid
	   
	   currentPlayer = Player.X;	// Reset the game variables to their defaults
	   gameOver = false;
	   winner = null;

	   play();						// Begin playing the game
   }
   

   public void play() {							//Controls the game play, rotates between player turns until a winner is decided.
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won
	         
	         if(gameOver) {						// Display results if game is over
	        	 if(winner == Player.X) {
	        		 System.out.println();
		        	 System.out.println("----Player X wins!----");
		        	 System.out.println();
		         }
	        	 else if (winner == Player.O) {
	        		 System.out.println();
		        	 System.out.println("----Player O wins----!");
		        	 System.out.println();
	        	 }
	        	 else { 
	        		 System.out.println();
	        		 System.out.println("----The game was a draw!----");
	        		 System.out.println();
	        	 }
	         }
	         
	         
	         if(currentPlayer == Player.X) {	// Switch turn to the next player
	        	 currentPlayer = Player.O;
	         } else {
	        	 currentPlayer = Player.X;
	         }
	         
	      } while (!gameOver);  				// Repeat until game-over
   }
 

   public void playerMove(Player turnPlayer) {	//Handles the player making their move, checks if the move is valid before making it.
	   
      boolean validInput = false;
      
      do {
    	  
    	  // Display instructions to the player
         if (turnPlayer == Player.X) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");  //Inform Player 'O' to enter their move 
         }
         
         int row = scanner.nextInt();			// Obtains input from the player for both row and column
         int col = scanner.nextInt();
         

         row--;									// Decrease the value entered by 1 to compensate for the array index starting at 0
         col--;
         
         // Verify the values the player entered are valid (position is valid and empty)
         if (row >= 0 && row < Grid.ROWS && col >= 0 && col < Grid.COLUMNS && grid.board[row][col].content == Player.EMPTY) {
        	 grid.board[row][col].content = turnPlayer;
        	 grid.currentRow = row;
        	 grid.currentCol = col;
        	 validInput = true;
         } else {
        	 
             System.out.println("Invalid location selected, please try again."); 		//Display an error message that the move was not valid.
         }
         
      } while (!validInput);   // Repeat until input is valid
   }
 

   public void checkForWinner(Player turnPlayer) {	//Checks if the game has ended
      if (grid.hasWon(turnPlayer)) {
    	  
    	  gameOver = true;
    	  winner = turnPlayer;					//Set gameOver and winner appropriately

      } else if (grid.isDraw()) {
    	  gameOver = true;
      }
   }
   
   public static void main(String[] args) {		//The main() method
	   
	   boolean playAgain = true;
	   boolean invalidInput = true;
	   do {
		   new GameMain();
		   System.out.println("Would you like to play again? (y/n)");
		   Scanner scanner = new Scanner(System.in);
		   String input = scanner.next();
		   do {
			   if (input.equals("y") || input.equals("Y")) {
				   playAgain = true;
				   invalidInput = false;
			   } else if (input.equals("n") || input.equals("N")) {
				   playAgain = false;
				   invalidInput = false;
			   } else {
				   System.out.println("INVAILD INPUT");
				   System.out.println();
				   System.out.println("Would you like to play again? (y/n)");
				   input = scanner.next();
			   }
		   } while (invalidInput);
		   
	   } while (playAgain);
	   
	   
	}
}