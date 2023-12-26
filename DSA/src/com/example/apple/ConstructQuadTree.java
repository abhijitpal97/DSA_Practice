package com.example.apple;

import com.example.datastructure.skeleton.QuadTree;

public class ConstructQuadTree {
	public QuadTree construct(int[][] grid) {
		return construct(grid , 0 , 0 , grid.length);
	}

	QuadTree construct(int[][] grid , int i , int j , int n)
	{
		if(isSame(grid , i , j , n)) return new QuadTree(grid[i][j] == 1 , true);
		else
		{
			QuadTree node = new QuadTree(false , false);
			node.topLeft = construct(grid , i , j , n/2);
			node.topRight = construct(grid , i , j+n/2 , n/2);;
			node.bottomLeft = construct(grid , i+n/2 , j , n/2);
			node.bottomRight = construct(grid , i+n/2 , j+n/2 , n/2);
			return node;
		}
	}

	boolean isSame(int[][] grid , int i , int j , int n)
	{
		for(int x = i ; x<i+n; x++)
		{
			for(int y = j ; y<j+n; y++)
			{
				if(grid[i][j] != grid[x][y]) return false;
			}
		}

		return true;
	}
}