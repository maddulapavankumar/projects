
public class TicTacToe {
	
	protected char[] board;
	protected char userMarker;
	protected char computerMarker;
	protected char winner;
	protected char currentMarker;
	public TicTacToe(char userMarker,char computerMarker) {
		this.userMarker=userMarker;
		this.computerMarker=computerMarker;
		this.board=setBoard();
		this.winner='-';
		this.currentMarker=userMarker;
	}
	public char[] setBoard() {
		char[] board=new char[9];
		for(int i=0;i<board.length;i++){
			board[i]='-';
		}
		return board;
	}
	public boolean choose(int place){
		boolean isItOk=isPlaceValid(place) && isPlaceEmpty(place);
		if(isItOk){
			board[place-1]=currentMarker;
			currentMarker=(this.currentMarker==userMarker)?computerMarker:userMarker;
			}
		return isItOk;
	}
	private boolean isPlaceEmpty(int place) {
		if(board[place-1]=='-'){
			return true;
		}
		return false;
	}
	private boolean isPlaceValid(int place) {
		// TODO Auto-generated method stub
		return place>0 && place<board.length+1;	
	}
	public boolean isThereAWinner(){
		boolean diagonalsAndMiddles=(rightDi()||leftdi()||middleRow()||middleCol()) && board[4]!='-';
		boolean topAndFirst = (topRow()||firstCol()) && board[0]!='-';
		boolean lastAndBottom=(bottomRow()||lastCol()) && board[8]!='-';
		if(diagonalsAndMiddles){
			this.winner=board[4];
		}
		else if(topAndFirst){
			this.winner=board[0];
		}
		else if(lastAndBottom){
			this.winner=board[8];
		}
		return diagonalsAndMiddles||topAndFirst||lastAndBottom;
	}
	public boolean bottomRow() {
		return board[6] == board[7] && board[7]==board[8];
	}
	public boolean lastCol() {
		return board[2] == board[5] && board[5]==board[8];
	}
	public boolean topRow() {
		return board[0] == board[1] && board[1]==board[2];
	}
	public boolean firstCol() {
		return board[0] == board[3] && board[3]==board[6];
	}
	public boolean middleCol() {
		return board[1] == board[4] && board[4]==board[7];
	}
	public boolean rightDi() {
		return board[2] == board[4] && board[4]==board[6];
	}
	public boolean leftdi() {
		return board[0] == board[4] && board[4]==board[8];
	}
	public boolean middleRow() {
		return board[3] == board[4] && board[4]==board[5];
	}
	public void printBoard(){
		for(int i = 0;i < board.length;i++){
			if(i % 3 == 0 && i != 0){
				System.out.println();
				System.out.println("--------------------");
			}
			System.out.print(" | "+board[i]);
		}
		System.out.println();
	}
	public static void initialBoard(){
		for(int i = 0;i < 9;i++){
			if(i % 3 == 0 && i != 0){
				System.out.println();
				System.out.println("--------------------");
			}
			System.out.print(" | "+(i+1));
		}
		System.out.println();
	}
	public boolean isBoardFilled(){
		for(int i=0;i<board.length;i++){
			if(board[i]=='-'){
				return false;
			}
			
		}
		return true;
	}
	public String gameOver(){
		if(isThereAWinner()){
			return "We have a winner "+this.winner;
		}
		else if(isBoardFilled()){
			return "Draw! Game over";
		}
		else{
			return "notOver";
		}
	}
	
}
