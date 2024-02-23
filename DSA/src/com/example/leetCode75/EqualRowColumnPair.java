package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/equal-row-and-column-pairs/

public class EqualRowColumnPair {
	public int equalPairs(int[][] grid) {
		Map<String , Integer> rowMap = new HashMap<>();
		int row = grid.length;
		int col = grid[0].length;
		int count = 0 ; 
		for(int i=0;i<row;i++)
		{
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<col;j++)
			{
				sb.append(grid[i][j]).append("_");
			}
			String str = sb.toString();
			rowMap.put(str , rowMap.getOrDefault(str , 0)+1);
		}

		for(int i=0; i< col ; i++)
		{
			StringBuilder sb = new StringBuilder();
			for(int j=0; j< row ; j++)
			{
				sb.append(grid[j][i]).append("_");
			}

			String str = sb.toString();
			if(rowMap.containsKey(str)) count += rowMap.get(str);

		}

		return count;
	}
}