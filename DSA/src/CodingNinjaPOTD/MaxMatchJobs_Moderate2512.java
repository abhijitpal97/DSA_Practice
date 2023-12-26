package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/placement-of-students_7411688

public class MaxMatchJobs_Moderate2512 
{
	public static int maxMatch(int[][] mat) 
	{
		// Write your code here
		int row = mat.length;
		int col = mat[0].length;
		Integer[] assign = new Integer[col];
		Arrays.fill(assign , -1);
		int count = 0;	

		for(int i=0;i<row;i++)
		{
			boolean[] isVisited = new boolean[col];
			if(dfs(i,isVisited,assign,mat,col)) count++;

		}

		return count;
	}

	static boolean dfs(int index , boolean[] isVisited , Integer[] assign , int[][] mat , int col)
	{
		for(int i = 0 ; i<col ; i++)
		{
			if(mat[index][i] == 1 && !isVisited[i])
			{
				isVisited[i] = true;

				if(assign[i] < 0 || dfs(assign[i] , isVisited , assign , mat , col))
				{
					assign[i] = index;
					return true;
				}
			}
		}
		return false;
	}
}