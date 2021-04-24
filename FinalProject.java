// JAY PATEL CSCI 1301 FINAL PROJECT
package finalProject;
import java.util.Arrays;
import java.util.Scanner;

public class FinalProject {

	public static int[][] puzzleOne() {
		int[][] grid =  {
				{ 0, 1, 2 }, 
				{ 3, 4, 5 }, 
				{ 6, 7, 8 } };
		
		
		return grid;
	}
	public static int[][] puzzleTwo() {
		int[][] grid = {
				{ 2, 4, 7 }, 
				{ 6, 1, 0 }, 
				{ 5, 8, 3 } };
	return grid;
	} 
	public static int[][] puzzleThree() {
	int[][] grid = {
				{ 1, 8, 2 }, 
				{ 0, 4, 3 }, 
				{ 7, 6, 5 } };
	return grid;
	}
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		//	User Instructions
		Scanner playerInput = new Scanner(System.in);
		System.out.println("Welcome to the 9-puzzle game made by Jay Patel. In this game you will \n"
				+ "have to move each number until you can rearrange them in a asending order\n(1 --> 8)."
				+ " If you want to quit or restart enter 0. Have Fun!!!\n");

		System.out.println("Please enter a number from 1 to 8 to begin your first Move.");
		//	9 - puzzle layout
		int [][] grid = puzzleOne();
		/*
		   Try puzzle two
		   int [][] grid = puzzleTwo();
		   Try puzzle three
		   int [][] grid = puzzleThree();
		   */
		
		// initialized variables / coordinates
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;

		int j = 0;
		int k = 0;
		int l = 0;
		int m = 0;

		int begin = 0;
		// starting layout for visual
		do {
			System.out.println(Arrays.toString(grid[begin]));
			begin++;
		} while (begin < grid.length);

		// 9 - puzzle Algorithm
		while (true) {
		// Validates user Input
			if (playerInput.hasNextInt()) {
				int numberFromUser = playerInput.nextInt();


		// Taxi cab method
				for (j = 0; j < grid.length; j++) {
					for (k = 0; k < grid.length; k++) {
						if(grid[j][k] == 0) {
							x1 = j;
							y1 = k;
						}
					}
				}

				for (l = 0; l < grid.length; l++) {
					for (m = 0; m < grid.length; m++) {
						if (grid[l][m] == numberFromUser) {
							x2 = l;
							y2 = m;

						}
					}
				}
				int operationForX = (x2 - x1);
				int operationForY = (y2 - y1);
				int a = Math.abs(operationForX);
				int b = Math.abs(operationForY);
				int c = ( a + b);


				if ( c == 1) {
					int move = grid[x1][y1];
					grid[x1][y1] = grid[x2][y2];
					grid[x2][y2] = move;
				}
		
		// prints grid after user made move
				if (numberFromUser > 0 && numberFromUser < 9) {
					System.out.println("Next Move:");

		
					for (int i = 0; i < grid.length; i++) {
						System.out.println(Arrays.toString(grid[i]));
					}

				}
		// End of game
				else {
					System.out.println("GAME OVER");
					break;
				}
			}
		}
	}
}
