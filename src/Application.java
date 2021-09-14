/*
 * Imports:
 */
import java.util.Random;

//import GridMove.vacuume;


/*
 * Application class is where the main method will run
 */
public class Application {
	
	//private static GridMove.vacuume vacuum;
	//Random random = new Random();
		static int n = 25;
		/*
		 * Main method will pass the GridMove class and create a new boolean
		 * matrix to be used with the random grid generator and 
		 */
		public static void main(String[] args) {
			
			//VacuumAgent v = new VacuumAgent();
			
			
			GridMove grid = new GridMove();
			
			GridMove.vacuume newV = new GridMove.vacuume();
			
			int x = 4;
			int y = 4;
			
			
			
			
			boolean [][] matrix = new boolean [x][y];
			
			grid.getRandomGrid(matrix);
			
			grid.positionRand(newV);
			
			for(int i = 0; i < n; i++) { 
				grid.action(matrix, newV);
				
				grid.getMove(newV);
				
			}
			
			
		}//END MAIN!

}
