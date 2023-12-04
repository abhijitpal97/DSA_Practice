package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/

public class MinOperationUniValue {

	public static void main(String[] args)
	{
		int res = minOperations(new int[][] {{1,2},{3,4}}, 2);
		System.out.println(res);
	}

	public static int minOperations(int[][] grid, int x) {
		List<Integer> list = new ArrayList<>();

		int row = grid.length;
		int col = grid[0].length;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				list.add(grid[i][j]);
			}
		}

		Collections.sort(list);
		int size = list.size();
		if(size == 1) return 0;
		if(size == 2)
		{
			int cD = list.get(1)-list.get(0);
			if(cD%x == 0) return cD/x;
			return -1;
		}
		int target = list.get(size/2);

		for(int i=1;i<size;i++)
		{
			int cD = list.get(i)-list.get(i-1);
			if(cD%x != 0) return -1;
		}

		int count = 0;
		for(int i=0;i<size;i++)
		{
			count += Math.abs(target - list.get(i))/x;
		}

		return count;
	}
}