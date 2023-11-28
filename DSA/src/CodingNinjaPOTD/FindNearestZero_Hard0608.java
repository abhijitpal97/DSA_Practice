package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/distance-of-nearest-cell-having-1-in-a-binary-matrix_1169913

public class FindNearestZero_Hard0608 {
	public static int[][] findNearestZero(ArrayList<ArrayList<Integer>> mat) {
		// Write Your Code here
		int row = mat.size();
		int col = mat.get(0).size();
		int[][] res = new int[row][col];
		for(int i=0;i<row;i++) Arrays.fill(res[i] , Integer.MAX_VALUE);

		for(int i=0;i<row;i++)
		{
			for(int j = 0; j<col;j++)
			{
				boolean[][] isVisited = new boolean[row][col];
				if(mat.get(i).get(j) == 1) dfs(i , j , i , j , row , col , isVisited,res, mat);
				else if(mat.get(i).get(j) == 0) res[i][j]=0;
			}
		}

		return res;
	}

	static void dfs(int starti, int startj , int i , int j , int row , int col , 
	boolean[][] isVisited , int[][] res, ArrayList<ArrayList<Integer>> mat)
	{
		if(i<0 || i>=row || j<0 || j>= col || isVisited[i][j]) return;
		isVisited[i][j] = true;
		if(mat.get(i).get(j) == 0)
		{
			int dist = calculateDistance(starti,startj,i,j);
			//System.out.println(res[starti][startj] + " -- "+dist);
			res[starti][startj] = Math.min(res[starti][startj] , dist);
			//System.out.println(" -----   "+res[i][j]);
		}

		dfs(starti,startj,i+1,j,row,col,isVisited,res,mat);
		dfs(starti,startj,i+1,j-1,row,col,isVisited,res,mat);
		dfs(starti,startj,i,j-1,row,col,isVisited,res,mat);
		dfs(starti,startj,i-1,j-1,row,col,isVisited,res,mat);
		dfs(starti,startj,i-1,j,row,col,isVisited,res,mat);
		dfs(starti,startj,i-1,j+1,row,col,isVisited,res,mat);
		dfs(starti,startj,i,j+1,row,col,isVisited,res,mat);
		dfs(starti,startj,i+1,j+1,row,col,isVisited,res,mat);
	}

	static int calculateDistance(int starti,int startj,int i,int j)
	{
		return Math.abs(starti-i)+Math.abs(startj-j);
	}
}