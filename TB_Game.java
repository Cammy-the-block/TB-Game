package TB_Game;
import java.util.Scanner;

public class TB_Game {

	public static void main(String[] args) {
		String whatToDo = menu();
		if (whatToDo.equalsIgnoreCase("Gangup")
				|| whatToDo.equalsIgnoreCase("1")) {
			gangup.startGangup();
		}

	}

	public static String menu() {
		String whatToDo;
		Scanner scannerS = new Scanner(System.in);
		System.out.print("Welcome to the TextBased Game! " + "\n" + "\n"
				+ "Which game do you wish to play?" + "\n" + "1 - Gangup"
				+ "\n" + "2 - Black Jack - Coming Soon");
		System.out.println();
		whatToDo = scannerS.nextLine();
		return whatToDo;
	}
	
}
