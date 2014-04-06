package TB_Game;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class cryptionGUI implements ClipboardOwner {

	public static int shift;

	public static void encrypt() {
		String afterShiftOne = "";
		String input = JOptionPane
				.showInputDialog("What do you wish to encrypt?");
		byte[] inputArray = input.getBytes();
		String shiftInput = JOptionPane
				.showInputDialog("How far do you wish to shift it?");
		shift = Integer.parseInt(shiftInput);
		String layersDeepInput = JOptionPane
				.showInputDialog("How many layers deep do you wish to encrypt?");
		int layersDeep = Integer.parseInt(layersDeepInput);

		for (int x = 0; layersDeep > x; x++) {
			inputArray = reverseArray(inputArray);
			inputArray = shiftArray(inputArray);
		}
		JOptionPane.showMessageDialog(null, "Encrypted version:"
				+ new String(inputArray), "TB Game", JOptionPane.PLAIN_MESSAGE);
		cryptionGUI.setClipboardContents(new String(inputArray));
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
			shift = (int) (shift + 1);
			array[x] = tempByteStorage;
		}
		shift = (int) (shift + 1);
		return array;
	}

	public static void decrypt() {
		String afterShiftOne = "";
		String input = JOptionPane
				.showInputDialog("What do you wish to decrypt?");
		byte[] inputArray = input.getBytes();
		String shiftInput = JOptionPane
				.showInputDialog("How far do you wish to deshift it?");
		shift = 0 -Integer.parseInt(shiftInput);
		String layersDeepInput = JOptionPane
				.showInputDialog("How many layers deep do you wish to encrypt?");
		int layersDeep = Integer.parseInt(layersDeepInput);
		shift = shift - (layersDeep * inputArray.length + layersDeep);
		for (int x = 0; layersDeep > x; x++) {
			inputArray = reverseArray(inputArray);
			inputArray = deshiftArray(inputArray);
		}
		JOptionPane.showMessageDialog(null, "Decrypted version:"
				+ new String(inputArray), "TB Game", JOptionPane.PLAIN_MESSAGE);
		cryptionGUI.setClipboardContents(new String(inputArray));
	}

	public static byte[] deshiftArray(byte[] array) {
		shift = (int) (shift + 1);
		byte tempByteStorage;
		for (int x = 0; array.length > x; x++) {
			shift = (int) (shift + 1);
			tempByteStorage = (byte) (array[x] + shift);
			array[x] = tempByteStorage;
		}
		return array;
	}
	public static  void setClipboardContents( String aString ){
	    StringSelection stringSelection = new StringSelection( aString );
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents( stringSelection, stringSelection );
	  }

	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// TODO Auto-generated method stub
		
	}
}