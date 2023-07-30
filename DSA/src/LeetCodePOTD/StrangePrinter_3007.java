package LeetCodePOTD;

public class StrangePrinter_3007 {
    public int strangePrinter(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return function(0 , n-1 , s , dp);        
    }

    int function(int start , int end , String s,Integer[][] dp)
    {
        if(start>end) return 0;
        if(dp[start][end] != null) return dp[start][end];

        int min = 1+function(start+1 , end , s , dp);
        for(int i = start+1 ; i<=end ; i++)
        {
            if(s.charAt(start) == s.charAt(i))
            {
                min = Math.min(min , function(start , i-1 , s, dp)+function(i+1 , end , s, dp));
            }
        }

        return dp[start][end] = min;
    }
}