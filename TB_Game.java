package TB_Game;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class TB_Game {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		String whatToDo;
		whatToDo = JOptionPane.showInputDialog("Welcome to the TextBased Game! " + "\n" + "\n"
				+ "Which game do you wish to play?" + "\n"
				+ "1 - Gangup - Work in Progress" + "\n"
				+ "2 - Black Jack - Coming Soon" + "\n" 
				+ "3 - Encryption - Non GUI" + "\n"
				+ "4 - Decryption - Non GUI" + "\n"
				+ "5 - Encryption GUI" + "\n"
				+ "6 - Decryption GUI" + "\n"
				+ "7 - Exit");
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
		if (whatToDo.equalsIgnoreCase("Encryption GUI")
				|| whatToDo.equalsIgnoreCase("5")) {
			cryptionGUI.encrypt();
		}
		if (whatToDo.equalsIgnoreCase("Decryption GUI")
				|| whatToDo.equalsIgnoreCase("6")) {
			cryptionGUI.decrypt();
		}
		if (whatToDo.equalsIgnoreCase("Exit")
				|| whatToDo.equalsIgnoreCase("7")) {
			exit();
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Option", "Error Message", JOptionPane.PLAIN_MESSAGE);
			menu();
		}
		}
		public static void exit() {
			int quit;
			quit = JOptionPane.showConfirmDialog(null, "Do you wish to close TB Game?");
			if (quit == 0) {
				JOptionPane.showMessageDialog(null, "Bye!", "TB Game", JOptionPane.PLAIN_MESSAGE);
				System.exit(0); 
			}
			else {
				menu();
			}
		}
	
}
