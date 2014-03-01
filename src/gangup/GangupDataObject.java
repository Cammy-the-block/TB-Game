package gangup;

public class GangupDataObject {

	private boolean isPiecePlaced = true;
	private int inputX;
	private int inputY;
	int[][] board;

	public GangupDataObject(boolean isPiecePlaced, int inputX, int inputY, int[][] board){
		this.isPiecePlaced = isPiecePlaced;
		this.inputX = inputX;
		this.inputY = inputY;
		this.board = board;
	}
	public GangupDataObject(){
		isPiecePlaced = false;
		inputX = -1;
		inputY = -1;
		board = null;
	}

	public boolean getIsPiecePlaced(){
		return isPiecePlaced;
	}
	public int getInputX(){
		return inputX;
	}
	public int getInputY(){
		return inputY;
	}
	public int[][] getBoard(){
		return board;
	}
}