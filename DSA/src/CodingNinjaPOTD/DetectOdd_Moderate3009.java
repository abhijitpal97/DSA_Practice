package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/moderate_9526304

public class DetectOdd_Moderate3009 {
	static int[] detectOdd(int n, int nums[]) {
		// Write your code here.
		Map<Integer,Integer> map = new HashMap<>();
		for(int i: nums) map.put(i , map.getOrDefault(i , 0)+1);

		int[] res = new int[2];
		int i = 0;
		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			if(m1.getValue()%2==1)
			{
				res[i] = m1.getKey();
				i++;
			}
		}

		Arrays.sort(res);
		return res;
	}
}