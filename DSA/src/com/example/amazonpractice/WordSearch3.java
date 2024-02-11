package com.example.amazonpractice;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/word-search_1095631

public class WordSearch3 {
	public static int[] wordSearch(String[] mat, int n, int m, String[] queries, int q) {
		// Write your code here.
		int[] res = new int[q];
		for(int i=0;i<q;i++)
		{
			res[i] = search(mat , n , m , queries[i])==true?1:0;
		}

		return res;
	}

	static boolean search(String[] mat , int n , int m , String word)
	{
		for(int i=0; i <n ; i++)
		{
			for(int j = 0 ;  j<m ; j++)
			{
				boolean[][] isVisited = new boolean[n][m];
				if(mat[i].charAt(j) == word.charAt(0))
				{
					//System.out.println(mat[i].charAt(j));
					boolean ans = dfs(mat , n , m , i , j , isVisited , word , 0);
					//System.out.println(ans);
					if(ans) return true;
				}
			}
		}
		return false;
	}

	static boolean dfs(String[] mat , int row , int col , int r , int c , 
			boolean[][] isVisited , String word , int index)
	{
		//System.out.println("Word Index - ");
		if(index == word.length()) return true;

		if(r<0 || r>=row || c<0 || c>= col || isVisited[r][c] 
				|| mat[r].charAt(c) != word.charAt(index)) return false;

		//System.out.println("Word IndexX - " +index);
		isVisited[r][c] = true;

		boolean up = dfs(mat , row , col , r-1 , c , isVisited , word , index+1);
		boolean down = dfs(mat , row , col , r+1 , c , isVisited , word , index+1);
		boolean left = dfs(mat , row , col , r , c-1 , isVisited , word , index+1);
		boolean right = dfs(mat , row , col , r , c+1 , isVisited , word , index+1);
		boolean ul = dfs(mat , row , col , r-1 , c-1 , isVisited , word , index+1);
		boolean ur = dfs(mat , row , col , r-1 , c+1 , isVisited , word , index+1);
		boolean dl = dfs(mat , row , col , r+1 , c-1 , isVisited , word , index+1);
		boolean dr = dfs(mat , row , col , r+1 , c+1 , isVisited , word , index+1);

		isVisited[r][c] = false;

		return up||down||left||right||ul||ur||dl||dr;
	}
}