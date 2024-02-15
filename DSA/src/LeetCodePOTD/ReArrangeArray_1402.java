package LeetCodePOTD;

// https://leetcode.com/problems/rearrange-array-elements-by-sign/

public class ReArrangeArray_1402 {
	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;

		int[] res = new int[n];
		int index = 0;
		for(int i=0;i<n;i++)
		{
			if(nums[i] >=0)
			{
				res[index] = nums[i];
				index += 2;
			}
		}

		index = 1;
		for(int i=0;i<n;i++)
		{
			if(nums[i] < 0)
			{
				res[index] = nums[i];
				index += 2;
			}
		}

		return res;
	}
}