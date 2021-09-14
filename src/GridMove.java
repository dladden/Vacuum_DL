/*
 * Imports:
 */
import java.util.Random;
/*
 * The goal of the Class Vacuum Agent is to 
 */
public class GridMove {
	
	/*
	 * Global Static variables which will be used to instantiate the position of the
	 * Vacuum. To manage the memory static variables will be created so that no class
	 * instantiation will be needed.
	 */
	//private static int x = 0;
	//private static int y = 0;
	//private static int visited = 0;
	private static boolean stop;//boolean checker to see if the movement is complete  
	
	static int xlegal = 4;//legal move to prevent put of bounds movemetn by vacuum on x plain
	static int ylegal = 4;//legal move to prevent put of bounds movement by vacuum on y plain
	
	/*
	 * Setting up a random class to be used for  randomizing the staring point of the 
	 * vacuum and the randomization of the Dirty Unoccupied and Clean Unoccupied locations 
	 */
	Random random = new Random();
	
	static int n; //Variable n which will be used to randomize the movement of the vacuum


	/*
	 * Method getRandomBoolean returns a random 
	 */
	public boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}//end get random
	
	/*
	 * The method POsition Random will randomize the starting position
	*/
	public static void positionRand(vacuume v) {
		
		Random random = new Random();
		
			v.x = random.nextInt(4);
			v.y = random.nextInt(4);
			
		}//end position random
		
	
	/*
	 * DU - Dirty Unoccupied
	 * DO - Dirty Occupied
	 * CU - Clean Unoccupied
	 * To generate the grid for the vacuum a boolean two-dimensional array will be 
	 * used in a form of a matrix. Vacuum agent will be going through two locations 
	 * a space that is dirty unoccupied and clean unoccupied. To randomize them
	 * getPrintDU_CU is used. by filling the matrix with boolean statements which are
	 * true  or false.
	 */
	public void Grid(boolean[][] matrix, int x, int y) {
		
	for (int a = 0; a < 4; a++) {	
		
		System.out.println("");
		
		for(int b = 0; b < 4; b++) {
			
			if(a == x && b == y) {
				
				System.out.print(" DO ");
				
			}//end if
			else
				getPrintDU_CU(matrix[a][b]);
		}//end for
		
		
		}//end for
	System.out.println("");
	}//end Grid
	
	/*
	 * getPrintDU_CU will be passed in the matrix generator so that we 
	 * can randomize the true and false positions of the 2D array
	 */
	public void getPrintDU_CU(Boolean bool){
        if(bool)
        	System.out.print(" DU ");
        else
        	System.out.print(" CU ");
	}
	
	
		/*
		 *class vacuum for the 
		 */
		public static class vacuume{
	        int x = 0;
	        int y = 0;
	        int visited = 0;
	    }
	
	
	/*
	 * This method will output the action of the vacuum agent and its location. By taking in 
	 * a boolean two dimensional array which will e randomized and checking if There also will
	 * be a way for the vacuum agent to 
	 */
	public void action(boolean[][] arrayBool, vacuume vacc) {
		
		
		if(arrayBool[vacc.x][vacc.y]) {
			
			Grid(arrayBool , vacc.x, vacc.y);
			
			arrayBool[vacc.x][vacc.y] = false;
			
			System.out.print("Vacuum's Percept: ");
			System.out.println("The square is dirty");
			System.out.println("Vacuum's Action: Clean then move");
			
		}else {
			
			Grid(arrayBool, vacc.x, vacc.y);
			
			
			System.out.print("Vacuum's Percept: ");
			System.out.println("The square is clean");
			System.out.println("Vacuum's Action: Moving");
		}
		
		
		System.out.print("Vacuum Current Location: ");
		System.out.println("X = " + vacc.x + ", Y = " + vacc.y);
		
	}
	
	
	/*
	 * The method get random grid will take the given 4 by 4 grid and use 
	 * get dirt method to randomly place clean or dirty positions on the 
	 * matrix
	 */
	public void getRandomGrid(boolean [][] arrayBool) {
		//this.x = x;
		//this.y = y;
		
		int x = arrayBool.length;
		int y = arrayBool[0].length;
		
		for(int a = 0; a < x; a++) {
			for(int b = 0; b < y; b++) {
				
				arrayBool[a][b] = getDirt();
			}//for 
				
		}//end for
		
	}// end get random grid
	
	/*
	 * getDirt will utilize the random class to output random true of false out
	 * put for the random grid generator
	 */
	 public boolean getDirt(){
	        n = random.nextInt(2);
	        if(n == 1)
	            return true;
	        return false;
	
	 }//end  get dirt
	
	
	
	/*
	 * Method Legal Move will make sure that the agent does not go off
	 * grid. THis method will then be used in the getmove method so that 
	 * if a move is legal the getmove can pass a next move and if not
	 * it can be corrected to the right move. 
	 */
	public boolean legalMove(int x, int y) {
		
		if((x < 0 || x >= xlegal || y < 0 || y >= ylegal)) {
			
			return false;
		}else{
				return true;
			}//end else
		
		
	}//end legal move
	
	
	/*
	 * The method getMove will utilize a while loop to iterate through random
	 * positions on the matrix (two dimensional array) and stop when it is 
	 * complete. The complexity of this move will be O(n) since one size 
	 * operation will be performed on each input of elements for n total moves.
	 * Additional since the vacuum object moves around randomly on a 4 by 4 two 
	 * dimensional array without having to take in any information about the arrays 
	 * there is no guarantee that it will clean every position. There is a possibility
	 * it could even run in a loop, which makes this method very inefficient.  
	 */
	public boolean getMove(vacuume vacuum) {
		
		stop = false;
		n = random.nextInt(4);
		
		while(!stop) {
			
			if(n == 0) {
			if(!legalMove(vacuum.x+1, vacuum.y)||n == vacuum.visited) {
			n = 2;
				
				}//end if
			else {
				vacuum.x++;
				vacuum.visited = 1;
				
				stop = true;
			}//end else
			
			
			}//end if one
			
				
			else if(n == 1) {
				if(!legalMove(vacuum.x-1, vacuum.y)||n == vacuum.visited) {
				n = 3;
					
					}//end if
				else {
					vacuum.x--;
					vacuum.visited = 0;
					
					stop = true;
			
				}
		}//end if two
			else if(n == 2) {
				if(!legalMove(vacuum.x, vacuum.y+1)||n == vacuum.visited) {
				n = 1;
					
					}//end if
				else {
					vacuum.y++;
					vacuum.visited = 3;
					
					stop = true;
			
				}
		}//end if three
		
			else if(n == 3) {
				if(!legalMove(vacuum.x, vacuum.y-1)||n == vacuum.visited) {
				n = 0;
					
					}//end if
				else {
					vacuum.y--;
					vacuum.visited = 2;
					
					stop = true;
			
				}
		}//end if two
			
	}//end WHILE 
	
		return true;
	}//END GET MOVE

	
	
}//end class Vacuum Agent 
