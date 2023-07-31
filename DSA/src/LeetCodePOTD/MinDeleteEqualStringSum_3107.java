package LeetCodePOTD;

public class MinDeleteEqualStringSum_3107 {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        Integer[][] dp  = new Integer[n+1][m+1];
        return  function(s1,s2,n,m,0,0,dp);
    }

    int function(String s1 , String s2 , int n , int m , int index1 , int index2 , Integer[][] dp)
    {
        int z = 0;
        if(index1==n && index2==m) return 0;
        if(index1==n || index2==m)
        {
            if(index1 == n)
            {
                for(int i=index2;i<m;i++) z += (int)s2.charAt(i);
            }
            else
            {
                for(int i=index1;i<n;i++) z += (int)s1.charAt(i);
            }
            return z;
        }

        if(dp[index1][index2] != null) return dp[index1][index2];
        if(s1.charAt(index1) == s2.charAt(index2)) return function(s1,s2,n,m,index1+1,index2+1 , dp);
        
        return dp[index1][index2] = 
            Math.min((int)s1.charAt(index1)+function(s1,s2,n,m,index1+1,index2,dp) , 
                     (int)s2.charAt(index2)+function(s1,s2,n,m,index1,index2+1,dp));
        
    }
}