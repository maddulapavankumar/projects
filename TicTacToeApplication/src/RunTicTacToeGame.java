import java.util.Scanner;

public class RunTicTacToeGame {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean doYouWantToPlay=true;
		while(doYouWantToPlay){
		System.out.println("Welocme to Tic Tac Toe!");
		System.out.println("Select a marker for you to present on the board!");
		char userToken=sc.next().charAt(0);
		System.out.println("Select a marker for the compute to present on the board!");
		char computerToken=sc.next().charAt(0);
		TicTacToe game=new TicTacToe(userToken,computerToken);
		Computer comp=new Computer();
		System.out.println("You can start the game!");
		TicTacToe.initialBoard();
		while(game.gameOver().equals("notOver")){
			if(game.currentMarker==game.userMarker){
				System.out.println("chooce a number from 1-9 in the box");
				game.printBoard();
				 int place = sc.nextInt();
				 while(!game.choose(place)){
					 System.out.println("not valid please try again");
					 place=sc.nextInt();
				 }
				 System.out.println("You picked "+place);	 
			}
			else{
				System.out.println("Its my turn");
				int spot=comp.pickBox(game);
				game.choose(spot);
				System.out.println("i picked"+spot);
			}
			game.printBoard();
			
		}
		System.out.println(game.gameOver());
		System.out.println("Type y to play again");
		char response=sc.next().charAt(0);
		doYouWantToPlay=(response=='y');
		System.out.println();
		}
	}

}
