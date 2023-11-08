package LeetCodePOTD;

import java.util.*;

public class IsReachableAtTimeT_0811 {
	
	// Brute Force
	public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
		int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{1,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{sx,sy});

		while(t != 0)
		{
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				int[] curr = queue.poll();
				for(int[] dir : dirs)
				{
					int currR = curr[0]+dir[0];
					int currC = curr[1]+dir[1];
					if(currR == fx && currC == fy && t == 1) return true;
					queue.offer(new int[]{currR,currC});
				}
			}
			t--;
		}
		return false;
	}
	
	// Math
	 public boolean isReachableAtTimeMath(int sx, int sy, int fx, int fy, int t) {
	        int xDist = Math.abs(sx-fx);
	        int yDist = Math.abs(sy-fy);

	        int minDist = Math.min(xDist,yDist)+Math.abs(xDist-yDist);

	        if(minDist == 0) return t!=1;
	        return t>=minDist;
	    }
}