package TB_Game;

import gangup.Gangup;

import javax.swing.JOptionPane;

import utils.Capitalize;
import utils.GuiMaster;

public class TB_Game {

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		GuiMaster.startGui();
		while(true){
			GuiMaster.println(
							"Welcome to the TextBased Game! \n"
							+ "\n" + "Which game do you wish to play? \n"
							+ "1 - Gangup - Work in Progress \n"
							+ "2 - Encryption - Non GUI \n"
							+ "3 - Decryption - Non GUI \n"
							+ "4 - Encryption Gui \n" 
							+ "5 - Decryption Gui \n"
							+ "6 - Alchemy - Work In Progress \n");
			String whatToDo = GuiMaster.getEnteredText();
			
			if (whatToDo == null) {
				exit();
			}
			whatToDo = whatToDo.trim();
			whatToDo = Capitalize.capitalizeEveryWord(whatToDo);
			
	        switch (whatToDo){
	        	case "Gangup":
	        	case "1":
	        		Gangup.startGangup();
	        		break;
	        	case "Encryption":
	        	case "2":
	        		cryption.encrypt();
	        		break;
	        	case "Decryption":
	        	case "3":
	        		cryption.decrypt();
	        		break;
	        	case "Encryption Gui":
	        	case "4":
	        		cryptionGUI.encrypt();
	        		break;
	        	case "Decryption Gui":
	        	case "5":
	        		cryptionGUI.decrypt();
	        	case "Alchemy":
	        	case "6":
	        		Alchemy.startAlchemy();
	        		break;
	        	default:
	        		GuiMaster.println("Invalid Option");
	        }			
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
