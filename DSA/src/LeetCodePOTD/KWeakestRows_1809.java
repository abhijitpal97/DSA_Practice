package LeetCodePOTD;

import java.util.*;

class WeakSoldierPair implements Comparable<WeakSoldierPair>
{
	int soldier;
	int row;

	WeakSoldierPair(int soldier , int row)
	{
		this.soldier = soldier;
		this.row = row;
	}

	public int compareTo(WeakSoldierPair that)
	{
		if(this.soldier == that.soldier) return this.row - that.row;
		return this.soldier - that.soldier;
	}
}


public class KWeakestRows_1809 {
	public int[] kWeakestRows(int[][] mat, int k) {
		int row = mat.length;
		int col = mat[0].length;

		Queue<WeakSoldierPair> pq = new PriorityQueue<>();

		for(int i=0;i<row;i++)
		{
			int soldiers = 0;
			for(int j=0;j<col;j++)
			{
				if(mat[i][j] == 1) soldiers++;
			}
			pq.offer(new WeakSoldierPair(soldiers , i));
		}

		int[] result = new int[k];
		int index = 0;

		while(k > 0)
		{
			result[index] = pq.poll().row;
			index++;
			k--;
		}

		return result;
	}
}