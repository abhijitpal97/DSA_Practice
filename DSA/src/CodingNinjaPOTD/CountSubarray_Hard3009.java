package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/subarrays-with-equal-0-s-1-s-and-2-s_2825370?leftPanelTab=1

public class CountSubarray_Hard3009 {

	public static void main(String[] args)
	{
		int res = countSubarrays(6, new int[] {1, 0, 2, 1, 0, 2});
		System.out.println(res);
	}

	public static int countSubarrays(int n, int[] arr) {

		// Write your code here.
		int ans = 0;
		// Initialize variables to store the count of 0's, 1's and 2's so far.
		int count0 = 0, count1 = 0, count2 = 0;
		HashMap < String, Integer > mp =   new HashMap < String, Integer >();
		mp.put("0$0", 1);
		for (int i = 0; i < n; i++) {

			// Update the value of count corresponding to the current element.
			if (arr[i] == 0) {
				count0++;
			} else if (arr[i] == 1) {
				count1++;
			} else if (arr[i] == 2) {
				count2++;
			}

			// Variable to store difference between number of 0's and 1's.
			int diff01 = count0 - count1;

			// Variable to store difference between number of 0's and 2's.
			int diff02 = count0 - count2;

			// Custom hash key.
			String hashKey = Integer.toString(diff01) + "$" + Integer.toString(diff02);

			int currAns = mp.getOrDefault(hashKey, 0);

			ans += currAns;

			mp.put(hashKey, currAns + 1);

		}

		return ans;


	}
}