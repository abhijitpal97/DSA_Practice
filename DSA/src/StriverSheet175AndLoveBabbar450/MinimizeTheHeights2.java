package StriverSheet175AndLoveBabbar450;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
public class MinimizeTheHeights2 {
	int getMinDiff(int[] arr, int n, int k) {
		Arrays.sort(arr);
		int ans = arr[n-1] - arr[0];
		int small = arr[0] + k;
		int large = arr[n-1] -k;
		int min,max;

		for(int i=0; i<n-1; i++)
		{
			min = Math.min(small , arr[i+1] - k);
			max = Math.max(large , arr[i] + k);

			if(min<0) continue;

			ans = Math.min(ans , max-min);
		}

		return ans;
	}
}
