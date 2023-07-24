package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class SplitArraySameAverage_Hard2407 {
    public static Boolean splitListWithSameAverage(int[] strengths) {
        // Write your code here.
        int strength = 0;
        for(int i:strengths) strength +=i;
        if(strength%2 == 1) return false;
        Boolean[][] dp= new Boolean[strengths.length][(strength/2)+1];
        return function(0 , strengths.length , strength/2, strengths , dp);

    }

    static boolean function(int index , int  n , int target , int[] strengths , Boolean[][] dp)
    {
        if(target == 0) return true;
        if(target<0) return false;
        if(index>=n) return false;

        if(dp[index][target] != null) return dp[index][target];
        boolean pick = function(index+1 , n , target-strengths[index] , strengths ,  dp);
        boolean notPick = function(index+1 , n , target , strengths ,dp);

        return dp[index][target] = pick || notPick;
    }
}