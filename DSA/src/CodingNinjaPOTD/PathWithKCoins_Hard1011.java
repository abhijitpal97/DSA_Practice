package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/path-with-k-coins_893399

public class PathWithKCoins_Hard1011 {

	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> list = 
				new ArrayList<>();
		list.add(new ArrayList<>(Arrays.asList(2,3,2,3,3)));
		list.add(new ArrayList<>(Arrays.asList(3,1,3,2,1)));
		list.add(new ArrayList<>(Arrays.asList(1,3,3,1,1)));
		list.add(new ArrayList<>(Arrays.asList(1,2,3,2,2)));

		int res = pathWithKCoins(list, 21);
		System.out.println(res);
	}

	static int MOD = 1000000007;
	public static int pathWithKCoins(ArrayList<ArrayList<Integer>> grid, int k) {

		// Write your code here.
		int row = grid.size();
		int col = grid.get(0).size();
		Integer[][][] dp = new Integer[row+1][col+1][k+1];
		return helper(grid , row , col , k , 0 , 0 , 0 , dp);

	}

	static int helper(ArrayList<ArrayList<Integer>> grid , int row , int col , int target , 
			int r , int c , int curr , Integer[][][] dp)
	{
		if(r==row-1 && c==col-1)
		{
			if(curr+grid.get(r).get(c) == target) return 1;
			else return 0;
		}
		if(r>=row || c>=col || curr>target) return 0;
		if(dp[r][c][curr] != null) return dp[r][c][curr]%MOD;

		int right = helper(grid , row ,col , target , r , c+1 , curr+grid.get(r).get(c) , dp);
		int down = helper(grid , row ,col , target , r+1 , c , curr+grid.get(r).get(c) , dp);

		return dp[r][c][curr] = (right%MOD+down%MOD)%MOD;


	}
}