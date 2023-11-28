package StriverSheet175AndLoveBabbar450;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

public class MaximumLengthSubArray {
    int max = Integer.MIN_VALUE;
    public int findLength(int[] nums1, int[] nums2) {
        max = Integer.MIN_VALUE;
        int n=nums1.length;
        int m =nums2.length;
        Integer[][] dp = new Integer[n+1][m+1];
        function(nums1,nums2,0,0,n,m,dp);
        return max;
    }

    int function(int[] nums1, int[] nums2 , int i , int j , int n , int m , Integer[][] dp)
    {
        if(i==n || j==m) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int x = 0;
        if(nums1[i]==nums2[j])
        {
            x = 1+function(nums1,nums2,i+1,j+1,n,m,dp);
        }
        max = Math.max(max , x);

        function(nums1,nums2,i+1,j,n,m,dp);
        function(nums1,nums2,i,j+1,n,m,dp);
        

        return dp[i][j] = x;
    }
}