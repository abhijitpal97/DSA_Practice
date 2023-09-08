package CodingNinjaPOTD;

public class takeAwayTheBottleInSubSet_Hard0809 {
	public static int takeAwayTheBottle(int[] arr,int n) {
		// Write your code here.
		return helper(0, n - 1, arr);
	}

	static int helper(int start , int end  , int[] arr)
	{
		if(start>end) return 0;
		if(start == end) return 1;

		if(arr[start] != arr[start+1]) 
		{
			int ans = 1+ helper(start+1,end,arr);

			for (int k = start + 1; k <= end; k++) {
				if (arr[start] == arr[k]) {
					ans = Math.min(ans, helper(start + 1, k - 1, arr) + helper(k + 1, end, arr));
				}
			}
			return ans;
		}
		else
		{
			int ans = 1+helper(start+1 , end , arr);
			ans = Math.min(ans , 1+ helper(start+2 , end , arr));

			for (int k = start + 2; k <= end; k++) {
				if (arr[start] == arr[k]) {
					ans = Math.min(ans, helper(start + 1, k - 1, arr) + helper(k + 1, end, arr));
				}
			}
			return ans;
		}
	}
}