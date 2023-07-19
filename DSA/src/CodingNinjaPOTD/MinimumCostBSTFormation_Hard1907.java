package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class MinimumCostBSTFormation_Hard1907 {
    public static int minCostBST(int arr[], int freq[]) {
        // Write your code here..
        int n = arr.length;

        int[][][] dp = new int[n][n][n+1];

        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <= n; k++) {
					dp[i][j][k] = -1;
				}
			}
		}




        return minCostSubArray(freq ,0, freq.length-1 , 1 , dp);
    }

    static int minCostSubArray(int[] freq , int start , int end , int index ,int[][][] dp)
    {
        if(start>end) return 0;

        if (dp[start][end][index] == -1) {

			dp[start][end][index] = Integer.MAX_VALUE;

			// Consider each key as root and recursively find an optimal solution.
			for (int k = start; k <=end; k++) {

				// Recursively find the optimal cost of the left subtree.
				int leftOptimalCost = minCostSubArray(freq, start, k - 1, 
                index + 1, dp);

				// Recursively find the optimal cost of the right subtree.
				int rightOptimalCost = minCostSubArray(freq, k + 1, end, 
                index + 1, dp);

				// Current node's cost is freq[k].
				// Update the optimal cost.
				dp[start][end][index] = Math.min(dp[start][end][index],
                 freq[k] * index + leftOptimalCost
						+ rightOptimalCost);
			}
		}

        return dp[start][end][index];
    }

}