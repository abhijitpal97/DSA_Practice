package LeetCodePOTD;

public class PredictWinner_2807 {
    public boolean PredictTheWinner(int[] nums) {
        Integer[][][] dp = new Integer[nums.length][nums.length][2];
        int total = 0;
        for(int i : nums) total +=i;

        int p1 = function(0,nums.length-1,nums,0,dp);
        int p2 = total - p1;

        return p1>=p2;
    }

    public int function(int start,int end,int[] nums,int player,Integer[][][] dp)
    {
        if(start>end) return 0;
        if(dp[start][end][player] != null) return dp[start][end][player] ; 

        int score = 0;
        if(player == 0)
        {
            score = Math.max(nums[start]+function(start+1 , end , nums , 1,dp) , nums[end]+function(start , end-1 , nums , 1,dp));
        }
        else
        {
            score = Math.min(function(start+1 , end , nums , 0,dp) , function(start , end-1 , nums , 0,dp));
        }

        return dp[start][end][player] = score;
    }
}