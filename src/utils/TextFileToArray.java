package utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TextFileToArray {

	private static int totalElements;
	private static int totalStartingElements;
	private static Scanner scanner;
	private static String elementListArray[][];
	private static String elementStringArray[];

	public boolean openFile(String file, String fileIde) { 
		try { //it tries using the method used to read from a jar
			scanner = new Scanner(TextFileToArray.class.getResourceAsStream(file));
			return true;
		} catch (Exception e1) { //if that fails, it tries to use the 
			try { //method to read from the IDE
				scanner = new Scanner(new File(fileIde)); 
				return true;
			}
			catch (Exception e2) {	//if it fails it prints out an error
				GuiMaster.println("WARNING: The file Elements.txt cannot be found.");
				return false; // and returns to alchemy, which eventually 
			} //returns to main menu
		}
	}

	public void readFile() {
		int x = 0;
		if (scanner.hasNext()) {
			totalElements = Integer.parseInt(scanner.next());
			elementStringArray = new String[totalElements];
			elementListArray = new String[totalElements][totalElements];
		}
		if (scanner.hasNext()) {
			totalStartingElements = Integer.parseInt(scanner.next());
		}
		while (scanner.hasNext()) {
			elementStringArray[x] = scanner.next();
			x++;
			if (x >= totalElements) {
				break;
			}
		}
		x = 0;
		int y = 0;
		while (scanner.hasNext()) {
			if (y == 0) {
				scanner.next();
				y++;
			} else if (y == totalElements) {
				elementListArray[x][y-1] = scanner.next();
				y = 0;
				x++;
			} else {
				elementListArray[x][y-1] = scanner.next();
				y++;
			}
		}
	}

	public static void closeFile() {
		scanner.close();
	}

	public static String[][] returnElementListArray() {
		return elementListArray;
	}

	public static String[] returnElementStringArray() {
		return elementStringArray;
	}

	public static int returnTotalElements() {
		return totalElements;
	}

	public static int returnTotalStartingElements() {
		return totalStartingElements;
	}
	
	public static void printelementListArray() {
		for (int x = 0; x <= totalElements - 1; x++) {
			for (int y = 0; y <= totalElements - 1; y++) {
				System.out.print(elementListArray[x][y] + ", ");
			}
			System.out.println();
		}
	}

	public static void printElementStringArray() {
		System.out.println();
		for (int x = 0; x <= elementStringArray.length - 1; x++) {
			System.out.print(elementStringArray[x] + " ");
		}
	}
}
