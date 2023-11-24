package StriverSheet175AndLoveBabbar450;
// https://www.geeksforgeeks.org/problems/rod-cutting0840/1

public class RodCuttingProblem{
    public int cutRod(int price[], int n) {
        //code here
        Integer[][] dp = new Integer[n][n+1];
        return function(n-1,n,price,dp);
    }
    
    int function(int index , int target , int[]price , Integer[][] dp)
    {
        if(index == 0) return price[0]*target;
        if(dp[index][target] != null) return dp[index][target];
        
        int pick = 0;
        if(index+1<=target) pick = price[index]+function(index,target-(index+1),price,dp);
        int notPick = function(index-1 , target, price , dp);
        
        return dp[index][target] = Math.max(pick,notPick);
    }
}
