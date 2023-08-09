package LeetCodePOTD;

import java.util.Arrays;

public class MiniMizeMax_0908 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length -1] - nums[0];

        while(start<=end)
        {
            int mid = start+ (end-start)/2 ;
            if(canHavePair(nums , p , mid)) end = mid-1;
            else start = mid+1;
        }

        return start;
    }

    boolean canHavePair(int[] nums , int pair , int maxDiff)
    {
        int start = 0;
        while(start<nums.length-1 && pair>0)
        {
            if(Math.abs(nums[start] - nums[start+1]) <= maxDiff)
            {
                start += 2;
                pair--;
            }
            else start++;
        }

        return pair<=0;
    }
}