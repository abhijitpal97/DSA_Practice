package CodingNinjaPOTD;

import java.util.*;

public class TakeAwayInAnySequencePalindrome_Hard0809 {
	public static int takeAwayTheBottle(int[] arr,int n) {
		// Write your code here.
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i : arr) map.put(i , map.getOrDefault(i , 0)+1);

		int bottle = 0;
		boolean hasEven = true;
		if(map.size() == 1) return 1;
		while(map.size()>0)
		{
			bottle++;
			List<Integer> li = new ArrayList<>();
			for(Map.Entry<Integer,Integer> m1 : map.entrySet())
			{
				int val = m1.getValue()%2;
				if(val == m1.getValue()) hasEven = false;
				if(val == 0) li.add(m1.getKey());
				else map.put(m1.getKey() , val);
			}
			for(int l : li) map.remove(l);

			if(hasEven == false) break;
		}
		return bottle+map.size()-1;
	}
}