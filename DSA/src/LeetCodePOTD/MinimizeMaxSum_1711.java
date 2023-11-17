package LeetCodePOTD;

import java.util.Arrays;

// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

public class MinimizeMaxSum_1711 {
    public int minPairSum(int[] nums) {
        //2 3 3 5
        //2 3 4 4 5 6

        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int start = 0;
        int end = n-1;
        while(start<end)
        {
            int curr = nums[start]+nums[end];
            res = Math.max(curr,res);
            start++;
            end--;
        }
        return res;
    }
}