package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class TotalWaysDynamic_Moderate2207
{
public static long totalWays(int a, int b, int c)
    {
        // Write your code here
        Integer[][][][] dp = new Integer[100][100][100][3]; 

        return countWay(a,b,c,0,dp)+countWay(a,b,c,1,dp)
        +countWay(a,b,c,2,dp);
    }

    static int countWay(int a,int b,int c,int last , Integer[][][][] dp)
    {
        if(a<0 || b<0 ||c <0) return 0;
        
        if(a==1 && b== 0 && c==0 && last ==0) return 1;
        if(a==0 && b== 1 && c==0 && last ==1) return 1;
        if(a==0 && b== 0 && c==1 && last ==2) return 1;

        if(dp[a][b][c][last] != null) return dp[a][b][c][last];
        
        if(last == 0)
        {
            dp[a][b][c][last] = countWay(a-1,b,c,1,dp)+countWay(a-1,b,c,2,dp);
        }
        if(last == 1)
        {
            dp[a][b][c][last] = countWay(a,b-1,c,0,dp)+countWay(a,b-1,c,2,dp);
        }
        if(last == 2)
        {
            dp[a][b][c][last] = countWay(a,b,c-1,0,dp)+countWay(a,b,c-1,1,dp);
        }

        return dp[a][b][c][last];
    }
}
