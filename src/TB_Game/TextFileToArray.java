package TB_Game;

import java.io.File;
import java.util.Scanner;

public class TextFileToArray {

	public static int totalElements = 17;
	public static Scanner scanner;
	public static String elementListArray[][] = new String[totalElements][totalElements];
	public static String elementStringArray[] = new String[totalElements];
	public static void main(String[] args){
	}
	
	public void openFile(String file){
		try{
			scanner = new Scanner(new File(file));
		}
		catch(Exception e){
			System.out.println("WARNING: The elements.txt cannot be found.");
		}
	}
	
	
	public void readFile(){
		int x = 0;
		while(scanner.hasNext()){		
			elementStringArray[x] = scanner.next();
			x++;
			if(x >= totalElements){
				break;
			}
		}
		x = 0;
		int y = 0;
		while(scanner.hasNext()){
			if(y == 0){
				scanner.next();
				y++;
			}
			else if(y == totalElements){
				elementListArray[x][y -1] = scanner.next();
				y = 0;
				x++;
			}
			else{
				elementListArray[x][y-1] = scanner.next();
				y++;
			}
		}
	}
	public static void closeFile(){
		scanner.close();
	}
	public static String[][] returnElementListArray(){
		return elementListArray;
	}
	public static String[] returnElementStringArray(){
		return elementStringArray;
	}
	public static void printelementListArray(){
		for(int x = 0; x <= totalElements-1;x++){
			for (int y = 0; y <= totalElements-1; y++ ){
				System.out.print(elementListArray[x][y] + ", ");
			}
			System.out.println();
		}
	}
	public static void printElementStringArray(){
		System.out.println();
		for(int x = 0; x <= elementStringArray.length-1; x++){
			System.out.print(elementStringArray[x] + " ");
		}
	}
}
