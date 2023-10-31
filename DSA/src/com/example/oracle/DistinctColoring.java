package com.example.oracle;

// https://practice.geeksforgeeks.org/problems/distinct-coloring--170645/1

public class DistinctColoring{
	static long min = Integer.MAX_VALUE;
	public static long distinctColoring(int N, int[]r, int[]g, int[]b){
		//code here
		min = Integer.MAX_VALUE;
		function(N,r,g,b,0,-1,0);
		return min;
	}

	static void function(int N, int[]r, int[]g, int[]b , int index , int prev,int col)
	{
		if(index>=N)
		{
			min = Math.min(min,col);
			return;
		}
		if(prev == -1)
		{
			function(N,r,g,b,index+1,1,col+r[index]);
			function(N,r,g,b,index+1,2,col+g[index]);
			function(N,r,g,b,index+1,3,col+b[index]);
		}
		if(prev==1)
		{
			function(N,r,g,b,index+1,2,col+g[index]);
			function(N,r,g,b,index+1,3,col+b[index]);
		}
		if(prev==2)
		{
			function(N,r,g,b,index+1,1,col+r[index]);
			function(N,r,g,b,index+1,3,col+b[index]);
		}
		if(prev==3)
		{
			function(N,r,g,b,index+1,1,col+r[index]);
			function(N,r,g,b,index+1,2,col+g[index]);
		}
	}
}