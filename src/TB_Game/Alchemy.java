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
	
	public static String elementArray[][]; //This array stores all of the elements and how they are 
	//formed. Input by reading Elements.txt	
	public static String elementStringArray[]; //This array stores each element in order. Used to 
	//find element's int and string.

	public static int elementsDiscovered[]= new int[totalElements]; // Stores the elements the
	//player has discovered. During setUpArrays it gets filled with starting elements and nothing
	
	public static void startAlchemy() {	
		setUpArrays(); 
		System.out.print("\n" + "Welcome to Alchemy!" + "\n" + "\n");
		System.out.println("Instructions: To start, input the "
				+ "first element that you would like to"
				+ " mix and press \"Enter\" and then in the"
				+ " same manner input the second element.");
		System.out.print("\n" + "\n");
		System.out.println("To start, you have");
		game(); //Main game loop 
	}

	public static void game() {
		while (game = true) {
			listElements(); //Prints out the elements you have
			Scanner scannerS = new Scanner(System.in);

			String element1 = scannerS.nextLine(); //inputs first element
	        elementValidize(element1); //checks first element, if invalid prints out text then starts
	        //game function over
			String element2 = scannerS.nextLine(); //inputs second element
			elementValidize(element2); //checks second element, if invalid prints out text then starts
			//game function over

			int newElementInt = findNewElement(element1, element2);//finds new element to be made int
			String newElement = elementString(newElementInt); //converts new element's int to string
			if(!checkValid(newElement)){ //Check valid checks if it's been discovered. If it has been 
				//then make it discovered.
				elementsDiscovered[elementsNotNull(elementsDiscovered)] = newElementInt;
			}
			System.out.println(element1 + " + " + element2 + " = " + newElement); 
			System.out.println("The elements you have discovered are, \n");
		}
	}
	
	public static void setUpArrays(){
		TextFileToArray tfta = new TextFileToArray(); //Creates new object used to import data
		tfta.openFile("Elements.txt"); //opens Elements.txt
		tfta.readFile(); //reads the file
		tfta.closeFile(); //closes file to prevent resource leak
		elementArray = tfta.returnElementListArray(); //populates elementaArray from data import from 
		//file earlier
		elementStringArray= tfta.returnElementStringArray(); // populates elementStringArray from data
		//import form file earlier
		fillArray(elementsDiscovered, totalStartingElements); //calls fillArray which populates 
		//elementsDiscovered with  starting elements then fills the rest with -1 to represent nothing
	}
	
	public static void fillArray(int[] array,  int actualDataSpots){
		for (int x = 0; x <= array.length -1; x++){ //fills in starting elements
			if(x <= actualDataSpots -1){
				array[x] = x;
			}
			else {            //fills the rest with -1
				array[x] = -1;
			}
		}
	}
	
	public static void listElements(){
		for (int x = 0; x <= elementsDiscovered.length-1; x++){ //goes through elementsDiscovered
			if(elementString(elementsDiscovered[x]) == null){ //finding the string of that postion's
				System.out.println("."); // int. then prints elements not null
				break;
			}
			else{
				System.out.print(elementString(elementsDiscovered[x])); // if an element is not null
				if(x != elementsDiscovered.length-1){ //then it will print out element. Checks to see 
					if(elementString(elementsDiscovered[x+1]) != null){ // if it is the last element 
						System.out.print(", "); // or if the next element is null, if so it prints out
					} // a period. Otherwise a comma is printed out.
				}
				else{
					System.out.println(".");
				}
			}
		}
	}

	public static void elementValidize(String element) {
		if (!checkValid(element)) { //calls checkValid to check if the element is valid if it isn't it
			System.out.println(""); //prints out some text then restarts game loop
			System.out.println("That is an element that"
					+ "either does not exist or that you"
					+ " have not yet obtained.");
			System.out.println("");
			System.out.println("Please try again.");
			System.out.println("The elements you have discovered are,\n");
			game();
		}
	}
	
	public static boolean checkValid(String element) {
		for (int x = 0; x <= elementsDiscovered.length -1; x++) { //goes through the elementsDiscovered
			int elementInt = elementNumber(element); //and checks if the int of the element passed
			if (elementInt == elementsDiscovered[x]){ //through matches any int in the elementsDiscovered
				return true;
			}
		}
		return false;
	}

	public static int findNewElement(String element1, String element2) {
		int element1Number = elementNumber(element1); //finds element number of element1
		int element2Number = elementNumber(element2); //and element2
		//System.out.println(element1 + " " + element2 + " " + element1Number + " " + element2Number);
		// above used for debugging
		String elementString = elementArray[element1Number][element2Number]; //finds the element in
		if(elementString.equalsIgnoreCase("error")){ //the location those two elements int's map.
			System.out.println("Nothing can be made with those elements. \n"); //If equals error it 
			System.out.println("The elements you have discovered are, \n"); // prints some text and 
			game(); // restarts game loop.
			return -1; //Java wants me to put a return
		}
		else{
			int elementNumber = elementNumber(elementString); //if actualy element is in the location
			return elementNumber; //the ints map then it returns that element
		}
	}

	public static int elementNumber(String element) { //locates the element in elementStringArray and
		for (int x = 0; x <= elementStringArray.length -1; x++) { //returns the string's int / 
			if (elementStringArray[x].equalsIgnoreCase(element)) { //the location of the string in the
				return x; //array
			}
		}
		return -2; //if not in there it returns -2
	}
	
	public static String elementString(int elementInt){ 
		if (elementInt == -1){ //-1 equals nothing so it returns null
			return null;
		}
		else{
			String elementString = elementStringArray[elementInt]; //if not it returns the string
			return elementString; //in that location in elementStringArray
		}
	}
	
	public static int elementsNotNull(int[] array){
		int elementsNotNull = 0; 
		for (int x = 0; x <= array.length-1; x++){ //searches through the array
			if (elementString(array[x]) != null){ //check the elements that are not null / int is not
				elementsNotNull++; // -1
			}
		}
		return elementsNotNull; 
	}
}