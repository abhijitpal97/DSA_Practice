package LeetCodePOTD;

// https://leetcode.com/problems/sort-array-by-parity/description/

public class SortArrayByParity_2809 {
	public int[] sortArrayByParity(int[] nums) {
		int start = 0;
		int end = nums.length-1;

		while(start<end)
		{
			if((nums[start]%2==0)) start++;
			else if(nums[end]%2==1) end--;
			else 
			{
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
		}

		return nums;
	}
}