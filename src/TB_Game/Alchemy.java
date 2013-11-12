package TB_Game;

import java.util.Scanner;

public class Alchemy {
	
	
	static boolean game = true;
	static int totalElements= 17;
	static int totalStartingElements = 4;
	//public static String elementArray[][]=
	      //   Time       Earth     Water       Air          Fire 	    Rock     Rust     Tarnish       Heat     Mud             Tornado        Lava	
/* Time  *///{{"error",   "Rock",    "Rust",     "Tarnish",   "Heat",   "error", "error", "Weathering", "Marble", "Muddy Slope", "Flying Rock", "error"}, 
/* Earth *///{"Rock",    "error",   "Mud",      "Tornado",   "Lava",   "Rock",  "error", "Crumbles",   "error",  "error",       "error",       "error" },
/* Water *///  {"Rust",    "Rock",    "error",    "Huricane",  "Steam",  "Pool",  "error", "error",      "Steam",  "Mud",         "Water Spout", "Obsidian"},
/* Air *///    {"Tarnish", "Tornado", "Huricane", "error",     "Embers", "error", "error", "error",      "Embers", "error",       "Tornado",     "Heat"},
/* fire*/ //   {"Heat",    "Lava",    "Steam",    "Embers",    "error"}};
	
	public static String elementArray[][];
	
	public static String elementStringArray[];

	public static int elementsDiscovered[]= new int[totalElements];
	
	
	public static void startAlchemy() {
		TextFileToArray tfta = new TextFileToArray();
		tfta.openFile("Elements.txt");
		tfta.readFile();
		tfta.closeFile();
		elementArray = tfta.returnElementListArray();
		elementStringArray= tfta.returnElementStringArray(); 
		
		
		fillArray(elementsDiscovered, totalStartingElements);
		System.out.print("\n" + "Welcome to Alchemy!" + "\n" + "\n");
		System.out.println("Instructions: To start, input the "
				+ "first element that you would like to"
				+ " mix and press \"Enter\" and then in the"
				+ " same manner input the second element.");
		System.out.print("\n" + "\n");
		System.out.println("To start, you have");
		game();
	}

	public static void game() {
		while (game = true) {
			listElements();
			Scanner scannerS = new Scanner(System.in);

			String element1 = scannerS.nextLine();
	        elementValidize(element1);
			String element2 = scannerS.nextLine();
			elementValidize(element2);

			int newElementInt = findNewElement(element1, element2);
			String newElement = elementString(newElementInt);
			elementsDiscovered[elementsNotNull(elementsDiscovered)] = newElementInt;
			System.out.println(element1 + " + " + element2 + " = " + newElement);
			System.out.println("The elements you have discovered are, \n");
		}
	}

	public static void fillArray(int[] array,  int actualDataSpots){
		for (int x = 0; x <= array.length -1; x++){
			if(x <= actualDataSpots -1){
				array[x] = x;
			}
			else {
				array[x] = -1;
			}
		}
	}
	
	public static void listElements(){
		for (int x = 0; x <= elementsDiscovered.length-1; x++){
			if(elementString(elementsDiscovered[x]) == null){
				System.out.println(".");
				break;
			}
			else{
				System.out.print(elementString(elementsDiscovered[x]));
				if(x != elementsDiscovered.length){
					if(elementString(elementsDiscovered[x+1]) != null){
						System.out.print(", ");
					}
				}
				else{
					System.out.println(".");
				}
			}
		}
	}

	public static void elementValidize(String element) {
		if (!checkValid(element)) {
			System.out.println("");
			System.out.println("I am sorry, that is an element that"
					+ "either does not exist or that you"
					+ " have not yet obtained.");
			System.out.println("");
			System.out.println("Please try again.");
			System.out.println("The elements you have discovered are,\n");
			game();
		}
	}
	
	public static boolean checkValid(String element) {
		for (int x = 0; x <= elementsDiscovered.length -1; x++) {
			int elementInt = elementNumber(element);
			if (elementInt == elementsDiscovered[x]){
				return true;
			}
		}
		return false;
	}

	public static int findNewElement(String element1, String element2) {
		int element1Number = elementNumber(element1);
		int element2Number = elementNumber(element2);
		System.out.println(element1 + " " + element2 + " " + element1Number + " " + element2Number);
		String elementString = elementArray[element1Number][element2Number];
		if(elementString.equalsIgnoreCase("error")){
			System.out.println("Nothing can be made with those elements. \n");
			System.out.println("The elements you have discovered are, \n");
			game();
			return -1;
		}
		else{
			int elementNumber = elementNumber(elementString);
			return elementNumber;
		}
	}

	public static int elementNumber(String element) {
		for (int x = 0; x <= elementStringArray.length -1; x++) {
			if (elementStringArray[x].equalsIgnoreCase(element)) {
				return x;
			}
		}
		return -2;
	}
	
	public static String elementString(int elementInt){
		if (elementInt == -1){
			return null;
		}
		else{
			String elementString = elementStringArray[elementInt];
			return elementString;
		}
	}
	
	public static int elementsNotNull(int[] array){
		int elementsNotNull = 0;
		for (int x = 0; x <= array.length-1; x++){
			if (elementString(array[x]) != null){
				elementsNotNull++;
			}
		}
		return elementsNotNull;
	}
}