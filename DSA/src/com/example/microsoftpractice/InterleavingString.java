package com.example.microsoftpractice;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int x =s1.length();
        int y = s2.length();
        int z = s3.length();
        Boolean[][][] dp = new Boolean[x+1][y+1][z+1];

        return function(s1,s2,s3,x,y,z,dp);
    }

    boolean function(String s1, String s2 , String s3 , int x , int y , int z , Boolean[][][] dp)
    {
        if(x== 0 && y==0 && z==0) return true;
        if((x == 0 && y == 0 && z!=0) 
        || (x != 0 && y != 0 && z==0) 
        || ((y != 0 && z!=0 && s2.charAt(0) != s3.charAt(0)) 
        && (x!=0 &&  z!=0 && s1.charAt(0) != s3.charAt(0)))) return false;
        

        if(dp[x][y][z] != null) return dp[x][y][z];
        boolean s1Check=false;
        boolean s2Check=false;
        if(x>0 && z>0 && s1.charAt(0)== s3.charAt(0))
        {
            s1Check = function(s1.substring(1),s2,s3.substring(1),x-1,y,z-1,dp);
        }
        if(y>0 && z>0 && s2.charAt(0)== s3.charAt(0))
        {
            s2Check = function(s1,s2.substring(1),s3.substring(1),x,y-1,z-1,dp);
        }

        return dp[x][y][z] = s1Check || s2Check;
    }
}