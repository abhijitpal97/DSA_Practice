package LeetCodePOTD;

public class CombinationSum4_0909 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Integer[] dp = new Integer[target+1];
        return function(nums , target , 0 , n , dp);
    }

    int function(int[] nums , int target , int index , int n , Integer[] dp)
    {
        if(target<0) return 0;
        if(target == 0) return 1;
        if(dp[target] != null) return dp[target];
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            ans += function(nums , target-nums[i] , i , n , dp);
        }
        return dp[target] = ans;
    }
}