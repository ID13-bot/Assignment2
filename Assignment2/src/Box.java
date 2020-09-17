
public class Box {

   Player content;			// The move this box holds (Empty, X, or O)
   int row, col; 			// Row and column of this box (Not currently used but possibly useful in future updates)
 
   public Box(int row, int col) {			//CONSTRUCTOR: Initialise the variables row, col, and content
	   
	   this.row = row;
	   this.col = col;
	   clear(); 		
   }
 

   public void clear() {					//Set the value of content to EMPTY
	   
	   content = Player.EMPTY;	
   }
 

   public void display() {					//Display the content of the box
	   
	   if (content == Player.X) {
		   System.out.print(" X ");
		   
	   } else if (content == Player.O) {
		   System.out.print(" O ");
		   
	   } else {
		   System.out.print("   ");
	   }
	   
   }	//end of display()
   
}	//end of class Box