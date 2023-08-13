package LeetCodePOTD;
import java.util.* ;
import java.io.*; 

public class MakeArrayElementsEqual {

	public static int findMinimumCost(int[] arr, int n) {
		// Write your code here
		Arrays.sort(arr);
		int med = findMedian(arr , n);
		//System.out.println();
		int res = 0;
		for(int i : arr) res += Math.abs(i - med);

		return res;

	}

	static int findMedian(int[] arr , int n)
	{
		if(n%2==1) return arr[n/2];
		return (arr[n/2]+arr[(n/2)-1])/2;
	}
}
