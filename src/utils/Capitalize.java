package utils;

public class Capitalize {
	
	public static String capitalizeFully(String string){
		boolean lastWasSpace = false;
		char[] stringArray = string.toCharArray();
		if(stringArray.length == 0){
			return "-1";
		}
		
		for (int x = 0;x <= stringArray.length - 1; x++){
			if(stringArray[x] == ' '){
				lastWasSpace = true;
			}
			else if(lastWasSpace){
				stringArray[x] = Character.toUpperCase(stringArray[x]);
				lastWasSpace = false;
			}
			else if(x == 0){
				stringArray[0] = Character.toUpperCase(stringArray[0]);
			}
		}
		
		string = new String(stringArray);
		return string;
	}
	
	public static String capitalizeEveryWord(String string){
		boolean lastWasSpace = false;
		
		char[] stringArray = string.toCharArray();
		if(stringArray.length == 0){
			return "-1";
		}
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		
		
		for (int x = 1;x <= stringArray.length - 1; x++){
			if(stringArray[x] == ' '){
				lastWasSpace = true;
			}
			else if(lastWasSpace){
				stringArray[x] = Character.toUpperCase(stringArray[x]);
				lastWasSpace = false;
			}
			else{
				stringArray[x] = Character.toLowerCase(stringArray[x]);
			}
		}
		
		string = new String(stringArray);
		return string;
	}
	
	public static String capitalizeFirstLetter(String string){
		char[] stringArray = string.toCharArray();
		if(stringArray.length == 0){
			return "-1";
		}
		stringArray[0] = Character.toUpperCase(stringArray[0]);	
		string = new String(stringArray);
		return string;
	}
	
	public static String capitalizeFirstLetterOnly(String string){
		char[] stringArray = string.toCharArray();
		if(stringArray.length == 0){
			return "-1";
		}
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		
		for (int x = 1;x <= stringArray.length - 1; x++){
			stringArray[x] = Character.toLowerCase(stringArray[x]);
		}
		
		string = new String(stringArray);
		return string;
	}

}
