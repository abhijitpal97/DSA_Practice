package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/k-sum-subset_2546852

public class KSumSubset_Hard2310 {
	static int max = Integer.MIN_VALUE;
	public static int kSumSubset(int[] array, int k) {

		// Write your code here..
		max = Integer.MIN_VALUE;
		function(array , 0 , array.length , 0 , k);
		return max;

	}

	static void function(int[] array , int index , int n , int sum , int target)
	{
		if(index >= n)
		{
			if(sum<= target)
			{
				max = Math.max(max , sum);
			}

			return;
		}

		function(array , index+1 , n , sum+array[index] , target);
		function(array , index+1 , n , sum , target);
	}

}