package TB_Game;

import java.util.Scanner;

public class TB_Game {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		String whatToDo;
		Scanner scannerS = new Scanner(System.in);
		System.out.print("Welcome to the TextBased Game! " + "\n" + "\n"
				+ "Which game do you wish to play?" + "\n"
				+ "1 - Gangup - Work in Progress" + "\n"
				+ "2 - Black Jack - Coming Soon" + "\n"
				+ "3 - Encryption - Work in Progress" + "\n"
				+ "4 - Decryption - Work in Progress");
		System.out.println();
		whatToDo = scannerS.nextLine();
		if (whatToDo.equalsIgnoreCase("Gangup")
				|| whatToDo.equalsIgnoreCase("1")) {
			gangup.startGangup();
		}
		if (whatToDo.equalsIgnoreCase("Encryption")
				|| whatToDo.equalsIgnoreCase("3")) {
			cryption.encrypt();
		}
		if (whatToDo.equalsIgnoreCase("Decryption")
				|| whatToDo.equalsIgnoreCase("4")) {
			cryption.decrypt();
		}
		else {
			System.out.println("Invalid Option");
			menu();
		}
	}
}
