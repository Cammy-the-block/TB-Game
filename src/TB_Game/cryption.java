package TB_Game;

import java.util.Scanner;

import utils.GuiMaster;

public class cryption {

	public static int shift;

	public static void encrypt() {
		String afterShiftOne = "";
		Scanner scanner = new Scanner(System.in);
		GuiMaster.println("What do you wish to encrypt?");
		byte[] inputArray = GuiMaster.getEnteredText().getBytes();
		GuiMaster.println("How far do you wish to shift it?");
		shift = Integer.parseInt(GuiMaster.getEnteredText());
		GuiMaster.println("How many layers deep do you wish to encrypt?");
		int layersDeep = Integer.parseInt(GuiMaster.getEnteredText());
		for (int x = 0; layersDeep > x; x++) {
			inputArray = reverseArray(inputArray);
			inputArray = shiftArray(inputArray);
		}
		GuiMaster.println("Encrypted version:" + new String(inputArray));
	}

	public static byte[] reverseArray(byte[] array) {
		int y = 0;
		byte[] returnArray = new byte[array.length];
		for (int x = array.length - 1; -1 < x; x--) {
			returnArray[x] = array[y];
			y++;
		}
		return returnArray;
	}

	public static byte[] shiftArray(byte[] array) {
		byte tempByteStorage;
		for (int x = 0; array.length > x; x++) {
			tempByteStorage = (byte) (array[x] + shift);
			shift = (int) (shift + 0);
			array[x] = tempByteStorage;
		}
		shift = (int) (shift + 0);
		return array;
	}

	public static void decrypt() {
		String afterShiftOne = "";
		Scanner scanner = new Scanner(System.in);
		GuiMaster.println("What do you wish to decrypt?");
		byte[] inputArray = GuiMaster.getEnteredText().getBytes();
		GuiMaster.println("How far do you wish to deshift it?");
		shift = 0 - Integer.parseInt(GuiMaster.getEnteredText());
		GuiMaster.println("How many layers deep do you wish to decrypt?");
		int layersDeep = Integer.parseInt(GuiMaster.getEnteredText());
		// shift = shift - layersDeep * inputArray.length + layersDeep;
		for (int x = 0; layersDeep > x; x++) {
			inputArray = reverseArray(inputArray);
			inputArray = deshiftArray(inputArray);
		}
		GuiMaster.println("Decrypted version:" + new String(inputArray));
	}

	public static byte[] deshiftArray(byte[] array) {
		shift = (int) (shift + 0);
		byte tempByteStorage;
		for (int x = 0; array.length > x; x++) {
			tempByteStorage = (byte) (array[x] + shift);
			shift = (int) (shift + 0);
			array[x] = tempByteStorage;
		}
		return array;
	}
}