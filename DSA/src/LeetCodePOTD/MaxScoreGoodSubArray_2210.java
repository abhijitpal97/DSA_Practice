package LeetCodePOTD;

// https://leetcode.com/problems/maximum-score-of-a-good-subarray/

public class MaxScoreGoodSubArray_2210 {
	public static void main(String[] args)
	{
		int max = maximumScore(new int[] {1,4,3,7,4,5}, 3);
		System.out.println(max);
	}

	public static int maximumScore(int[] nums, int k) {

		int left = k;
		int right = k;
		int min = nums[k];
		int max = min;

		while(left >0 || right < nums.length -1)
		{
			if(left == 0 || 
					right<nums.length-1 && nums[right+1]>nums[left-1]) right++;
			else left--;

			min = Math.min(min , Math.min(nums[left] , nums[right]));
			max = Math.max(max , min*(right-left+1));
		}

		return max;

	}

}