package com.example.amazonpractice;

import java.util.Arrays;

public class NegetiveWeightCycle_BellmonFord
{	    
	public static void main(String[] args)
	{
		int res = isNegativeWeightCycle(5, new int[][] {{1, 0, 5},{1, 2, -2},{1, 4, 6},{2, 3, 3},{3, 1, -4}});
		System.out.println(res);
	}

	public static  int bellman(int s,int n,int [][]edges){

		int dist[]=new int[n];

		for(int i=0;i<n;i++){
			dist[i]=Integer.MAX_VALUE;
		}

		dist[s]=0;

		for(int i=0;i<n-1;i++){
			for(int arr[] : edges){

				int u=arr[0];
				int v=arr[1];
				int wt=arr[2];

				if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
					dist[v]=dist[u]+wt;
				}
			}
		}
		for(int arr[] : edges){


			int u=arr[0];
			int v=arr[1];
			int wt=arr[2];

			if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
				return 1;
			}
		}
		return 0;
	}

	public static int isNegativeWeightCycle(int n, int[][] edges)
	{
		for(int i=0;i<n;i++){

			if(bellman(i,n,edges)==1)
				return 1;
		}

		return 0;
	}
}
