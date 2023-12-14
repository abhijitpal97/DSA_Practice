package LeetCodePOTD;

// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column

public class OneZeroDifference_1412 {
	public int[][] onesMinusZeros(int[][] grid) {
		int n =grid.length;
		int m = grid[0].length;

		int[][] zeros = new int[n][m];
		int[][] ones = new int[n][m];

		int[][] res = new int[n][m];

		for(int i = 0 ; i<n ; i++)
		{
			for(int j = 0 ; j<m ; j++)
			{
				int[] zo = calculate(grid , i , j , n , m );
				zeros[i][j] = zo[0];
				ones[i][j] = zo[1];
			}
		}

		for(int i=0;i<n;i++)
		{
			for(int j=0 ; j<m ; j++)
			{
				res[i][j] = ones[i][j] - zeros[i][j];
			}
		}

		return res;
	}

	int[] calculate(int[][] grid , int r , int c , int row , int col)
	{
		int zero = 0;
		int one = 0;
		for(int i=0; i<row ; i++)
		{
			if(grid[i][c] == 0) zero++;
			if(grid[i][c] == 1) one++;
		}

		for(int i=0;i<col ; i++)
		{
			if(grid[r][i] == 0) zero ++;
			if(grid[r][i] == 1) one++;
		}

		return new int[]{zero , one};
	}
}