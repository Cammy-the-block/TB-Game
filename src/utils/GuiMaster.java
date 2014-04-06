package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class GuiMaster {

	static String lastEnteredText;
	static JTextArea display;
	static boolean haveRecivedInput = false;
	
	public static void startGui(){

		JPanel middlePanel = new JPanel ();
		middlePanel.setBorder(new TitledBorder(new EtchedBorder (), "TB Game" ) );

		// create the middle panel components

		display = new JTextArea(16,58 );
		JScrollPane scroll = new JScrollPane(display);

		display.getDocument().addDocumentListener(new AL());
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		//Add Textarea in to middle panel
		middlePanel.add(scroll);

		
		JFrame frame = new JFrame();
		frame.add( middlePanel );
		frame.setTitle("TB Game");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private static void setEnteredText(String enteredText) {
		// TODO Auto-generated method stub
		lastEnteredText = enteredText;
		haveRecivedInput = true;
	}
	
	public static String getEnteredText(){
		while(!haveRecivedInput){
			
		}
		haveRecivedInput = false;
		display.setCaretPosition(display.getDocument().getLength());
		return lastEnteredText;
	}
	
	public static void println(String message){
		display.append(message + "\n");
		haveRecivedInput = false;
		display.setCaretPosition(display.getDocument().getLength());
	}

	
	
	private static class AL implements DocumentListener {


		@Override
		public void insertUpdate(DocumentEvent e) {
			boolean haveNotEncounteredInvis = true;
			char lastChar;
			String fieldText = null;
			Document doc = (Document)e.getDocument();

			try {
				fieldText =doc.getText(0, doc.getLength());
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
			if(fieldText.length() > 1){
				lastChar = fieldText.charAt(fieldText.length() - 1);
				if(lastChar == '\n'){
	
					int x = fieldText.length()-2;
					String enteredText = "";
					char currentChar;
					
					while(haveNotEncounteredInvis){
						currentChar = fieldText.charAt(x);
						if(currentChar == '\n' ){
							setEnteredText(enteredText);
							haveNotEncounteredInvis = false;
							display.setCaretPosition(display.getDocument().getLength());
						}
						else if(x == 0){
							enteredText = currentChar + enteredText;
							setEnteredText(enteredText);
							haveNotEncounteredInvis = false;	
						}
						else{
							enteredText = currentChar + enteredText;
						}
						x--;
					}
				}
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	}
}
