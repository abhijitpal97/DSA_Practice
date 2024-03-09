package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/ninja-ant_1229380

public class NinjaAnt_Moderate2602 {
	public static ArrayList<Integer> ninjaAnt(int[][] mat, int sr, int sc, int moves) {		 
		// Write your code here.
		char curr = 'E';
		int row = mat.length;
		int col = mat[0].length;

		for(int i = 0; i<moves; i++)
		{
			if(curr == 'E')
			{
				if(mat[sr][sc] == 1)
				{
					mat[sr][sc] = 0;
					curr = 'S';
					sr++;
				}
				else if(mat[sr][sc] == 0)
				{
					mat[sr][sc] = 1;
					curr = 'N';
					sr--;
				}
			}

			else if(curr == 'S')
			{
				if(mat[sr][sc] == 1)
				{
					mat[sr][sc] = 0;
					curr = 'W';
					sc--;
				}
				else if(mat[sr][sc] == 0)
				{
					mat[sr][sc] = 1;
					curr = 'E';
					sc++;
				}
			}

			else if(curr == 'W')
			{
				if(mat[sr][sc] == 1)
				{
					mat[sr][sc] = 0;
					curr = 'N';
					sr--;
				}
				else if(mat[sr][sc] == 0)
				{
					mat[sr][sc] = 1;
					curr = 'S';
					sr++;
				}
			}

			else if(curr == 'N')
			{
				if(mat[sr][sc] == 1)
				{
					mat[sr][sc] = 0;
					curr = 'E';
					sc++;
				}
				else if(mat[sr][sc] == 0)
				{
					mat[sr][sc] = 1;
					curr = 'W';
					sc--;
				}
			}

			if(sr>=row || sr<0 || sc<0 || sc>=col) return new ArrayList<>(Arrays.asList(-1,-1));
		}

		return new ArrayList<>(Arrays.asList(sr,sc));
	}
}

