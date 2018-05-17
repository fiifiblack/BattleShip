package battleShip;

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

/**
 * Evans Appiah, ITTP @author GCE Battle Ship Project 02/26/2018 Contact Evans @
 * ( evans.appiah@me.com) if you want a copy of this property. All rights
 * reserved.
 */

public class BattleShip {

	static {
		System.out.println("Game Guidance:" + '\n' + "Welcome to Battle  Ship.");
		System.out.println("The game is won when all ship are destroyed.");
		System.out.println("The right grid cordinates seleted will destroy ship(s) at that location.");
		System.out.println("Welcome to Battle  Ship.");
		System.out.println("\"*\" represents five spaces on the grip .");
		System.out.println("*************************************************************************"+'\n' );
	}
	static String[][] Usergrid = new String[20][20];
	static int[][] grid = new int[20][20];
	static int missedCount = 0;
	private static int Hits;
	static int firstCordinate;
	private static int secondCordinate;
	static int numberOfShots = 100;
	static int shipsDestroyed = 0;

	public static void main(String[] args) throws java.io.IOException {
		for (int i = 0; i < Usergrid.length; i++) {// making user grid
			for (int j = 0; j < Usergrid.length; j++) {
				Usergrid[i][j] = "~";
			}
		}

		// marking 5 spaces with *
		Usergrid[0][5] = "*";
		Usergrid[0][10] = "*";
		Usergrid[0][15] = "*";

		Usergrid[5][0] = "*";
		Usergrid[10][0] = "*";
		Usergrid[15][0] = "*";

		/*
		 * random number to set ships at locations with value of ! & value on 1 via IF
		 * statements
		 */

		int select = (int) (Math.random() * 3 + 1);
		int select1 = (int) (Math.random() * 3 + 1);
		int select2 = (int) (Math.random() * 3 + 1);
		int select3 = (int) (Math.random() * 3 + 1);
		int select4 = (int) (Math.random() * 3 + 1);
		int select5 = (int) (Math.random() * 4 + 1);

		/*
		 * accepting random values to set ship location ,space, and value
		 * 
		 */
		if (select == 1) {
			Arrays.fill(grid[1], 1, 6, 1);
		} else if (select == 2) {
			Arrays.fill(grid[2], 5, 10, 1);

		} else if (select == 3) {
			Arrays.fill(grid[3], 7, 12, 1);
		}

		if (select1 == 1) {
			Arrays.fill(grid[8], 4, 9, 1);
		} else if (select1 == 2) {
			Arrays.fill(grid[6], 2, 7, 1);

		} else if (select1 == 3) {
			Arrays.fill(grid[7], 8, 13, 1);
		}

		if (select5 == 1) {// works
			Arrays.fill(grid[9], 1, 5, 1);
		} else if (select5 == 2) {
			Arrays.fill(grid[10], 5, 9, 1);

		} else if (select5 == 3) {
			Arrays.fill(grid[11], 10, 14, 1);
		} else if (select5 == 4) {
			Arrays.fill(grid[12], 8, 12, 1);
		}

		if (select3 == 1) {
			Arrays.fill(grid[13], 4, 8, 1);
		} else if (select3 == 2) {
			Arrays.fill(grid[14], 2, 6, 1);

		} else if (select3 == 3) {
			Arrays.fill(grid[15], 8, 12, 1);
		}

		if (select4 == 1) {
			Arrays.fill(grid[17], 1, 5, 1);
		} else if (select4 == 2) {
			Arrays.fill(grid[18], 5, 9, 1);

		} else if (select4 == 3) {
			Arrays.fill(grid[18], 10, 14, 1);
		}

		if (select2 == 1) {
			Arrays.fill(grid[16], 1, 3, 1);
		} else if (select2 == 2) {
			Arrays.fill(grid[4], 13, 15, 1);

		} else if (select2 == 3) {
			Arrays.fill(grid[5], 10, 12, 1);
		}

		do {

			try {
				Scanner sc = new Scanner(System.in);// accepting user input
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Please enter row cordinate");
				firstCordinate = sc.nextInt();
				if (firstCordinate < 0 || firstCordinate > 20) {
					System.out.println("Please enter only numbers \"0-19\" cordinates \nStart Over");
					System.exit(0);
				}

				System.out.println("Please enter column cordinate");
				secondCordinate = sc.nextInt();
				if (secondCordinate < 0 || secondCordinate > 19) {
					System.out.println("Please enter only numbers \"0-19\" cordinates \nStart Over");
					System.exit(0);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Please enter only numbers \"0-20\" cordinates \nStart Over");
				System.exit(0);
			}

			System.out.println("Updated Board: Cheat Sheet");
			System.out.println();

			// displaying ship locations as 1 and negative with 0
			for (int i = 0; i < grid.length; i++) {// CheatSheet: Ship Locater
				for (int j = 0; j < grid.length; j++) {

					System.out.print(grid[i][j] + " ");
				}
				System.out.println("");
			}

			System.out.println();

			// inserting "!" if ship is shot and deleting value of 1 to 0
			if (grid[firstCordinate][secondCordinate] == 1) {
				System.out.println("Hit!!!!!!!!Hit!!!!!!!!!Hit!!!!!!" + '\n');
				numberOfShots--;
				System.out.println("Number of shots left :" + numberOfShots + '\n');
				Usergrid[firstCordinate][secondCordinate] = "!";
				grid[firstCordinate][secondCordinate] = 0;
				Hits++;
				// error checking //defense in depth
				if (Hits == 24) {
					System.out.println("You WON!" + '\n' + "All ship have been destroyed");
					System.out.println("Start over to play again" + '\n');
					System.exit(0);
				}
				int ship = 0;
				for (int i = 0; i < grid[firstCordinate].length; i++) { // checking ship length
					int[] j = grid[firstCordinate];// assigned array to J
					ship += j[i];// counting in array(0s and 1s) if strand of ship in still there
				}

				if (ship == 0) {
					shipsDestroyed++;
					System.out.println("Ship Destroyed \nNumber of Ship(s) Destroyed: " + shipsDestroyed);
				}

			} else if (grid[firstCordinate][secondCordinate] == 0) {
				System.out.println("Miss-_- -_- Miss-_- -_- Miss-_- " + '\n');
				numberOfShots--;
				System.out.println("Number of shots left :" + numberOfShots + '\n');

				Usergrid[firstCordinate][secondCordinate] = "M";
				missedCount++;

				if (missedCount == 100) {// exit game if missed 24 times //defense in depth
					System.out.println("You Lost!" + '\n' + "Game Over");

					System.exit(0);
				}
			}

			// print grid with ships
			for (int i = 0; i < Usergrid.length; i++) {
				for (int j = 0; j < Usergrid.length; j++) {
					System.out.print(Usergrid[i][j] + " ");
				}
				System.out.println("");
			}

		} while (Hits != 24 && missedCount != 100);
		if (Hits == 24) {//defense in depth
			System.out.println(" You WON! Game is over");
			System.out.println("Start over to play again" + '\n');
			System.exit(0);
		}else if (missedCount == 100) {// exit game if missed 100 times
			System.out.println("You Lost!" + '\n' + "Game Over");
			System.out.println("Start over to play again" + '\n');
			System.exit(0);
		}

	}

	// MAIN ENDS@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public static void UserGrid(String a[][]) {// prints String grid

		String[][] Usergrid = new String[20][20];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {

				Usergrid[i][j] = "~";

				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void Grid() {// prints Integer grid

		int[][] grid = new int[20][20];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {

				grid[i][j] = 0;

				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
	}

}

