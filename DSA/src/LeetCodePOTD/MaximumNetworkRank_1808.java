package LeetCodePOTD;

public class MaximumNetworkRank_1808 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] inDegree = new int[n];
        int[][] connected = new int[n][n];

        for(int[] road : roads)
        {
            int s = road[0];
            int d = road[1];
            connected[s][d] = 1;
            connected[d][s] = 1;
            inDegree[s]++;
            inDegree[d]++;
        }

        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;
                ans = Math.max(ans , inDegree[i]+inDegree[j]-connected[i][j]);
            }
        }

        return ans;
    }
}