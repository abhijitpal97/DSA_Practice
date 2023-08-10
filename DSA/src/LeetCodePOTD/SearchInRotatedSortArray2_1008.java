package LeetCodePOTD;

public class SearchInRotatedSortArray2_1008 {
	public boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length-1;

		while(start<=end)
		{
			if(nums[start] == target || nums[end] == target) return true;
			if(target>nums[start])
			{
				start++;
			}
			else
			{
				end--;
			}
		}

		return false;
	}
}