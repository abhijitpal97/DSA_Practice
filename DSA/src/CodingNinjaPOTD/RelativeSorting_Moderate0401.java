package CodingNinjaPOTD;
import java.util.*;
// https://www.codingninjas.com/studio/problems/relative-sorting_1792851

public class RelativeSorting_Moderate0401 {
	public static List<Integer> relativeSorting(List<Integer> arr, List<Integer> brr, int n, int m) {
		// Write your code here
		Map<Integer,Integer> map = new TreeMap<>();
		for(int i : arr) map.put(i , map.getOrDefault(i,0)+1);

		List<Integer> list = new ArrayList<>();
		for(int i : brr)
		{
			if(map.containsKey(i))
			{
				int count = map.get(i);
				for(int j=0;j<count;j++) list.add(i);
				map.remove(i);
			}
		}

		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			int count = m1.getValue();
			for(int j=0;j<count;j++) list.add(m1.getKey());
		}

		return list;
	}
}