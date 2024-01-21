package LeetCodePOTD;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-minimums/

public class SumSubArrayMins_2001 {
	public int sumSubarrayMins(int[] arr) {
		long res = 0;
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		long mod = (long)1e9+7;

		stack.push(-1);

		for(int i = 0 ; i<n+1 ; i++)
		{
			int curr = i<n?arr[i] : 0 ;

			while(stack.peek() != -1 && curr<arr[stack.peek()])
			{
				int idx = stack.pop();
				int i1 = stack.peek();
				int left = idx-i1;
				int right = i-idx;

				long add = (long)(left*right*(long)arr[idx])%mod;
				res += add;
				res %= mod;
			}
			stack.push(i);
		}

		return (int)res;
	}
}