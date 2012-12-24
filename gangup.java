package TB_Game;

import java.util.Scanner;

public class gangup {
	
	public static void startGangup(){
		
		int[][] board = new int[8][8];
		System.out.print("Welcome to TB Game's Gangup. ");
		board = clearGangupBoard(board);
		printGangupBoard(board);
	}
	public static int[][] clearGangupBoard(int[][] board){
		
		for (int x = 0; x <= 7; x++){
			for (int y = 0; y <= 7; y++){
				board[x][y] = 0;
			}
		}
		return board;
	}
	public static void printGangupBoard(int[][] board){
		
		for (int x = 0; x <= 7; x++){
			System.out.println();
			System.out.print(7 - x + " ");
			for (int y = 0; y <= 7; y++){
				System.out.print(board[x][y] + " ");
			}
		}
		System.out.print("\n" + "  0 1 2 3 4 5 6 7");
	}
	public static void gangupTurn(){
		Scanner scannerC = new Scanner(System.in);
		System.out.print("Where do you want to go [XY]?");
		String input = scannerC.next();
		char x = input.charAt(1);
		char y = input.charAt(2);
		
	}

}
