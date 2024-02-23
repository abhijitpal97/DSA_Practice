package LeetCodePOTD;

// https://leetcode.com/problems/find-the-town-judge/

public class FindJudge_2202 {
	public int findJudge(int n, int[][] trust) {
		int[] inDegree = new int[n+1];
		int[] outDegree = new int[n+1];

		for(int[] curr : trust)
		{
			int a = curr[0];
			int b = curr[1];

			outDegree[a]++;
			inDegree[b]++;
		}

		for(int i=1;i<=n;i++)
		{
			if(inDegree[i] == n-1 && outDegree[i] == 0) return i;
		}
		return -1;
	}
}