package LeetCodePOTD;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/description/

public class Find132Pattern_3009 {
	public boolean find132pattern(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack<>();
		int third = Integer.MIN_VALUE;

		for(int i=n-1;i>=0;i--)
		{
			if(nums[i]<third) return true;

			while(! stack.isEmpty() && stack.peek()<nums[i]) third = stack.pop();

			stack.push(nums[i]);
		}

		return false;
	}
}