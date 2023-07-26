package LeetCodePOTD;

public class NumberOfLongestIncreasignSubsequence_2107 {
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];

        // longest Length -- Count
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        int maxC = 1;
        int maxF = 1;

        for(int i = 1; i<nums.length;i++)
        {
            int longest = 1;
            int freq = 1;

            for(int j=i-1 ; j>= 0 ; j--)
            {
                if(nums[i]>nums[j])
                {
                    if(dp[j][0] +1 > longest)
                    {
                        longest = dp[j][0]+1;
                        freq = dp[j][1];
                    }
                    else if(dp[j][0]+1 == longest)
                    {
                        freq +=dp[j][1];
                    }
                }
            }

            dp[i][0] = longest;
            dp[i][1] = freq;

            if(longest>maxC)
            {
                maxC = longest;
                maxF = freq;
            }
            else if(longest == maxC)
            {
                maxF += freq;
            }
        }

        return maxF;

    }
}