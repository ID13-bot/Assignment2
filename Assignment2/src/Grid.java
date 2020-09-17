
public class Grid {								// The grid represents the game board.
												// Define the amount of rows and columns
	public static final int ROWS = 3;			// Rows
	public static final int COLUMNS = 3;		// Columns
 
	Box[][] board;								// Represents the game board as a grid
	int currentRow;								// Row that was played last
	int currentCol;								// Column that was played last
	
	
   public Grid() {								//Constructor
      
	  board = new Box[ROWS][COLUMNS];			//Initialise the board array using ROWS and COLUMNS
      
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
            board[row][col] = new Box(row, col);
         }
      }
   }
 

   public boolean isDraw() {					//Checks if the game has ended in a draw
	   
	   for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLUMNS; ++col) {
	            if (board[row][col].content == Player.EMPTY) {
	            	return false;
	            }
	         }  
	      }
	   return true;
   }
 

   public boolean hasWon(Player player) {			//Return true if the turn player has won after making their move at the coordinate given

	   if(board[currentRow][0].content == player && board[currentRow][1].content == player && board[currentRow][2].content == player) {		// Row check
		   return true;
	   }
	   
	   if(board[0][currentCol].content == player && board[1][currentCol].content == player && board[2][currentCol].content == player) {		// Column check
		   return true;
	   }
	   
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {		// Diagonal check 
		   return true;
	   }
	   if(board[0][2].content == player && board[1][1].content == player && board[2][0].content == player) {		// Diagonal check 
		   return true;
	   }
	   else {
		   return false;
	   }
	   
   }
 

   public void display() {
      for (int row = 0; row < ROWS; ++row) {				//Draws the tic-tac-toe board to the screen
         for (int col = 0; col < COLUMNS; ++col) {
        	 
        	 board[row][col].display();						//Draw the contents of the box
        	 
        	 if (col < COLUMNS - 1) System.out.print("|");	//Draw the vertical line
    	 }
         System.out.println();
         
         if (row < ROWS - 1) {
        	 System.out.println("-----------");				//Draw the horizontal line
         }
      }
   }
}	//End of class Grid