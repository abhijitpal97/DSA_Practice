package CodingNinjaPOTD;

import java.util.*;

// https://www.codingninjas.com/studio/problems/save-ninja-land_2826683

public class SaveNinjaLand_Hard2210 {

	public static int minDaysToContainK(int n, int k, int[][] points) {
		// Write your code here.
		Map<String,Integer> visited = new HashMap<>();
		Map<String,List<Integer>> map = new HashMap<>();
		Queue<int[]> queue = new LinkedList<>();
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		int index = 0;
		int time = 0;
		for(int[] point : points)
		{
			int r = point[0];
			int c = point[1];
			String key = r+"@"+c;
			int[] newP = new int[3];
			newP[0]=point[0];
			newP[1]=point[1];
			newP[2]=index;

			if(visited.containsKey(key))
			{
				if(map.get(key).contains(index)) continue;
				else
				{
					map.get(key).add(index);
					queue.offer(newP);
					if(map.get(key).size() == k) return 0;
				}
			}
			else
			{
				visited.put(key , 1);
				map.put(key , new ArrayList<>(Arrays.asList(index)));
				queue.offer(newP);
			}

			index++;
		}

		while(! queue.isEmpty())
		{
			int size = queue.size();
			for(int i=0;i<size;i++)
			{
				int[] curr = queue.poll();
				int ind = curr[2];
				for(int[] dir : dirs)
				{
					int cR = curr[0]+dir[0];
					int cC = curr[1]+dir[1];
					String key = cR+"@"+cC;
					if(visited.containsKey(key))
					{
						if(map.get(key).contains(ind)) continue;
						else
						{
							map.get(key).add(ind);
							queue.offer(new int[] {cR,cC,ind});
							if(map.get(key).size() == k) return time+1;
						}
					}
					else
					{
						visited.put(key , 1);
						map.put(key , new ArrayList<>(Arrays.asList(ind)));
						queue.offer(new int[] {cR,cC,ind});
					}
				}
			}
			time++;
		}

		return -1;
	}

}