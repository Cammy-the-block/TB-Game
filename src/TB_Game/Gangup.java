package TB_Game;

import java.util.Scanner;

import utils.GangupDataObject;


public class Gangup {


	public static void startGangup() {
		int playerNumber = 1;
		int[][] board = new int[8][8];
		System.out.print("Welcome to TB Game's Gangup. ");
		board = clearGangupBoard(board);
		gangupLoop(board);
	}

	private static void gangupLoop(int[][] board) {
		boolean continueLoop = true;
		int playerNumber = 1;
		int turnNumber = 1;
		int consecutiveConectionsRequired = 3;
		int numberOfPlayers = 4;
		GangupDataObject recievedDataObject;

		while (continueLoop == true){
			recievedDataObject = placePiece(board, playerNumber);

			if(recievedDataObject.getIsPiecePlaced()) {
				if(checkForWin(turnNumber, recievedDataObject.getInputX(), recievedDataObject.getInputY(),
						recievedDataObject.getBoard(), consecutiveConectionsRequired, numberOfPlayers)){
					win(playerNumber);
					continueLoop = false;
				};
				turnNumber++;
				if(playerNumber < 4){
					playerNumber++;
				}
				else{
					playerNumber = 1;
				}
			}
			else invalidMove();
		}
	}


	private static GangupDataObject placePiece(int[][] board, int playerNumber){
		int inputX, inputY;
		int[] inputArray;
		int[] inputAndPiecePlacedArray = new int[3];

		inputArray = inputMove(board, playerNumber);
		inputX = inputArray[0];
		inputY = inputArray[1];

		boolean isPiecePlaced = checkMove(inputX, inputY, board, playerNumber);

		GangupDataObject returnObject = new GangupDataObject(isPiecePlaced, inputX, inputY, board);

		return returnObject;
	}


	private static int[] inputMove(int[][] board, int playerNumber){

		System.out.print("\n" + "Player #" + playerNumber);
		printGangupBoard(board);
		Scanner scannerInt = new Scanner(System.in);
		System.out.print("\n" + "Where do you want to go?" + "\n" + "X Y:");
		int inputX = scannerInt.nextInt();
		int inputY = scannerInt.nextInt();
		int[] inputArray = {inputX, inputY};
		return inputArray;
	}

	private static boolean checkMove(int inputX, int inputY, int [][] board, int playerNumber) {

		if ((inputX <= 8 && inputX >= 1) && (inputY <= 8 && inputY >= 1) &&
				(board[inputX-1][inputY-1]== 0)){

			board[inputX-1][inputY-1] = playerNumber;
			return true;
		}
		else{
			return false;
		}
	}

	private static int[][] clearGangupBoard(int[][] board) {

		for (int x = 0; x <= 7; x++) {
			for (int y = 0; y <= 7; y++) {
				board[x][y] = 0;
			}
		}
		return board;
	}



	private static void printGangupBoard(int[][] board) {

		for (int y = 8; y >= 1; y--) {
			System.out.println();
			System.out.print(y + " ");
			for (int x = 1; x <= 8; x++) {
				System.out.print(board[x-1][y-1] + " ");
			}
		}
		System.out.println("\n" + " 1 2 3 4 5 6 7 8");
	}


	private static void invalidMove() {

		System.out.print("Invalid Move");
	}
	private static boolean checkForWin(int turnNumber, int inputX, int inputY, int[][] board,
			int consecutiveConectionsRequired, int numberOfPlayers){

		if(turnNumber > (numberOfPlayers * (consecutiveConectionsRequired - 1))){
			if(checkGrid(board[inputX-1][inputY-1], board, consecutiveConectionsRequired)){
				return true;
			}
		}
		return false;
	}


	// Returns true if given playerType is forming a connection, else false.
	public static boolean checkGrid(int playerType, int [][] grid,
			int consecutiveConectionsRequired){
		int rows = grid.length;
		int columns = grid[0].length;
		// Check downward
		for (int i = 0; i <= rows - consecutiveConectionsRequired; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				int counter = 0;
				for (int k = i; k < consecutiveConectionsRequired + i; k++)
				{
					if (grid[k][j] == playerType)
						counter++;
				}

				if (counter == consecutiveConectionsRequired)
					return true;
			}
		}

		// Check across
		for (int i = 0; i <= columns - consecutiveConectionsRequired; i++)
		{
			for (int j = 0; j < rows; j++)
			{
				int counter = 0;
				for (int k = i; k < consecutiveConectionsRequired + i; k++)
				{
					if (grid[j][k] == playerType)
						counter++;
				}

				if (counter == consecutiveConectionsRequired)
					return true;
			}
		}

		// Check left to right diagonally
		for (int i = 0; i <= rows - consecutiveConectionsRequired; i++)
		{
			for (int j = 0; j <= columns - consecutiveConectionsRequired; j++)
			{
				int counter = 0;
				for (int k = i, m = j; k < consecutiveConectionsRequired + i; k++, m++)
				{
					if (grid[k][m] == playerType)
						counter++;
				}

				if (counter == consecutiveConectionsRequired)
					return true;
			}
		}

		// Check right to left diagonally
		for (int i = 0; i <= rows - consecutiveConectionsRequired; i++)
		{
			for (int j = columns - 1; j >= columns - consecutiveConectionsRequired; j--)
			{
				int counter = 0;
				for (int k = i, m = j; k < consecutiveConectionsRequired + i; k++, m--)
				{
					if (grid[k][m] == playerType)
						counter++;
				}

				if (counter == consecutiveConectionsRequired)
					return true;
			}
		}

		return false;
	}

	private static void win(int playerNumber) {
		System.out.println("Good job player #" + playerNumber);

	}

}

