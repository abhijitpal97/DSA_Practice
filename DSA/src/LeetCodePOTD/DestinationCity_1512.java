package LeetCodePOTD;
// https://leetcode.com/problems/destination-city

import java.util.*;

public class DestinationCity_1512 {
	public String destCity(List<List<String>> paths) {
		Map<String , int[]> map = new HashMap<>();

		for(List<String> path : paths)
		{
			String src = path.get(0);
			String dest = path.get(1);

			if(map.containsKey(src))
			{
				int[] curr = map.get(src);
				curr[1]++;
				map.put(src , curr);
			}
			else map.put(src ,new int[]{0,1});

			if(map.containsKey(dest))
			{
				int[] curr = map.get(dest);
				curr[0]++;
				map.put(dest , curr);
			}
			else map.put(dest ,new int[]{1,0});
		}

		for(Map.Entry<String , int[]> m1 : map.entrySet())
		{
			int[] curr = m1.getValue();
			if(curr[1] == 0) return m1.getKey();
		}
		return "";
	}
}