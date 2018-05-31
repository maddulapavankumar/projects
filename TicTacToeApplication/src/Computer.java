import java.util.ArrayList;
import java.util.Random;

public class Computer {
	public int pickBox(TicTacToe game){
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<9;i++){
			if(game.board[i]=='-'){
				list.add(i+1);
			}
		}
		Random rand=new Random();
		int choice=list.get(Math.abs(rand.nextInt()) % list.size());
		return choice;
	}
}
