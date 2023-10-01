package CodingNinjaPOTD;

import java.util.*;

// https://www.codingninjas.com/studio/problems/equal-candies_1467692

public class DistributeEqualCandyCost_Moderate1707 {

	public static long equalCandies (ArrayList<Integer> candies, int n) {
		// Write your code here
		Collections.sort(candies);

		int target = candies.get(n/2);

		int result = 0;
		for(int i=0;i<n;i++) result +=Math.abs(candies.get(i) - target);

		return result;

	}
}