package TB_Game;

import java.util.Scanner;

public class gangup {

	public static void startGangup() {
		int playerNumber = 1;
		int[][] board = new int[8][8];
		System.out.print("Welcome to TB Game's Gangup. ");
		board = clearGangupBoard(board);
		gangupTurn(board, playerNumber);
	}
	public static int[][] clearGangupBoard(int[][] board) {

		for (int x = 0; x <= 7; x++) {
			for (int y = 0; y <= 7; y++) {
				board[x][y] = 0;
			}
		}
		return board;
	}
	public static void printGangupBoard(int[][] board) {

		for (int x = 7; x >= 0; x--) {
			System.out.println();
			System.out.print(x + " ");
			for (int y = 0; y <= 7; y++) {
				System.out.print(board[x][y] + " ");
			}
		}
		System.out.print("\n" + "  0 1 2 3 4 5 6 7");
	}
	public static void gangupTurn(int[][] board, int playerNumber) {
		
		System.out.print("\n" + "Player #" + playerNumber);
		printGangupBoard(board);
		Scanner scannerInt = new Scanner(System.in);
		System.out.print("\n" + "Where do you want to go?" + "\n" + "X Y:");
		int inputX = scannerInt.nextInt();
		int inputY = scannerInt.nextInt();
		if ((inputX < 8 && inputX >= 0) && (inputY < 8 && inputY >= 0)){
			if (board[inputY][inputX]== 0){
				
				board[inputY][inputX] = playerNumber;
				boolean win = checkForWin();
				if (win == true){					
				}
				else{
					if (playerNumber < 4){
						
						playerNumber++;
						gangupTurn(board, playerNumber);
					}
					else {
						playerNumber = 1;
						gangupTurn(board, playerNumber);
					}
				}
			}
			else{
				invalidMove(board, playerNumber);
			}
		}
		else{
			invalidMove(board, playerNumber);
		}
	}
	private static void invalidMove(int[][] board, int playerNumber) {
		
		System.out.print("Invalid Move");
		gangupTurn(board, playerNumber);
	}
	public static boolean checkForWin(){
		
		return false;
	}
}
