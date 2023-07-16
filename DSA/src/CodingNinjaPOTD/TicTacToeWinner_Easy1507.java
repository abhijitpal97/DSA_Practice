package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class TicTacToeWinner_Easy1507 {
	
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> moves = new ArrayList<>();
		moves.add(new ArrayList<>(Arrays.asList(0,0)));
		moves.add(new ArrayList<>(Arrays.asList(0,1)));
		moves.add(new ArrayList<>(Arrays.asList(1,1)));
		moves.add(new ArrayList<>(Arrays.asList(1,0)));
		moves.add(new ArrayList<>(Arrays.asList(2,1)));
		moves.add(new ArrayList<>(Arrays.asList(2,2)));
		moves.add(new ArrayList<>(Arrays.asList(2,0)));
		moves.add(new ArrayList<>(Arrays.asList(0,2)));
		moves.add(new ArrayList<>(Arrays.asList(1,2)));
		
		String res = ticTacToeWinner(moves, 9);
		System.out.println(res);
	}
	
	public static String ticTacToeWinner(ArrayList<ArrayList<Integer>> moves, int n) {
		// Write your code here
		char[][] board = new char[3][3];
		for(int i=0;i<3;i++) Arrays.fill(board[i] , '.');
		for(int i=0;i<moves.size();i++)
		{
			int r = moves.get(i).get(0);
			int c = moves.get(i).get(1);
			if(i%2==0) board[r][c] = 'X';
			else board[r][c] = 'O';			
		}

//		for(int i=0;i<3;i++)
//		{
//			System.out.println(board[i][0] + " - " + board[i][1]+" - "+board[i][2]);
//		}

		char ch = checkForWinner(board);
		if(ch == 'X') return "player1";
		if(ch == 'O') return "player2";
		if(ch == '.') return "uncertain";
		if(ch == '-') return "draw";
		return "Wrong Answer";
	}

	static char checkForWinner(char[][] board)
	{
		boolean hasblank=false;
		//check columnwise
		//check rowWise
		for(int i=0;i<3;i++)
		{
			if((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) return board[i][0];
			else
			{
				if(board[i][0] == '.' || board[i][1] == '.' || board[i][2] == '.') hasblank = true;
			}

			if((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) return board[0][i];
			else
			{
				if(board[0][i] == '.' || board[1][i] == '.' || board[2][i] == '.') hasblank = true;
			}
		}
		//check diagonally
		if((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) return board[0][0];
		if((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) return board[0][2];

		//check uncertain
		if(hasblank) return '.';
		else return '-';
		
	}
}