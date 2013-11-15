package TB_Game;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.text.WordUtils;

public class TB_Game {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		String whatToDo = JOptionPane
				.showInputDialog("Welcome to the TextBased Game! " + "\n"
						+ "\n" + "Which game do you wish to play?" + "\n"
						+ "1 - Gangup - Work in Progress" + "\n"
						+ "2 - Black Jack - Not Been Finished" + "\n"
						+ "3 - Encryption - Non GUI" + "\n"
						+ "4 - Decryption - Non GUI" + "\n"
						+ "5 - Encryption GUI" + "\n" + "6 - Decryption GUI"
						+ "\n" + "7 - Alchemy - Work In Progress" + "\n"
						+ "8 - Exit");
		if (whatToDo == null) {
			JOptionPane.showMessageDialog(null, "Invalid Option",
					"Text Based Game", JOptionPane.PLAIN_MESSAGE);
			menu();
		}
		whatToDo = whatToDo.trim();
		
		whatToDo = WordUtils.capitalize(whatToDo);
        switch (whatToDo){
        	case "Gangup":
        	case "1":
        		gangup.startGangup();
        		break;
        	case "Black Jack":
        	case "2":
        		JOptionPane.showMessageDialog(null, "Black Jack has not been finished", "Text Based Game",
    					JOptionPane.PLAIN_MESSAGE);
    			menu();
    			break;
        	case "Encryption":
        	case "3":
        		cryption.encrypt();
        		break;
        	case "Decryption":
        	case "4":
        		cryption.decrypt();
        		break;
        	case "Encryption GUI":
        	case "5":
        		cryptionGUI.encrypt();
        		break;
        	case "Decryption GUI":
        	case "6":
        		cryptionGUI.decrypt();
        	case "Alchemy":
        	case "7":
        		Alchemy.startAlchemy();
        		break;
        	case "Exit":
        	case "8":
        		exit();
        	default:
        		JOptionPane.showMessageDialog(null, "Invalid Option", "Text Based Game", JOptionPane.PLAIN_MESSAGE);
    			menu();
    			
        }
      
		
	}

	public static void exit() {
		int quit;
		quit = JOptionPane.showConfirmDialog(null,
				"Do you wish to close TB Game?");
		if (quit == 0) {
			System.exit(0);
		} else {
			menu();
		}
	}

}
