package CodingNinjaPOTD;
import java.util.*;  

// https://www.codingninjas.com/studio/problems/coupons_2262396

public class Coupouns_Moderate1902 {

	public static int pickCoupons(int n, int[] coupons) {
		// Write your code here
		Map<Integer,Integer> map = new HashMap<>();
		// 3->2, 4->1 , 5->1 
		int min = Integer.MAX_VALUE; // 4
		int start = 0;

		for(int i=0;i<n; i++)
		{
			int curr = coupons[i];
			map.put(curr , map.getOrDefault(curr , 0)+1);
			while(map.get(curr) == 2)
			{
				min = Math.min(min , i-start+1);
				int startC = coupons[start];
				int startV = map.get(startC);
				map.put(startC , startV-1);
				if(map.get(startC) == 0) map.remove(startC);
				start++;
			}
		}

		return min==Integer.MAX_VALUE?-1:min;
	}

}
