package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/perfect-team_1265035

public class PerfectTeam_Hard1012 {
	public static int perfectTeam(ArrayList<Integer> age, ArrayList<Integer> skill, int n) {
		// Write your code here.
		int[][] v = new int[n][2];

		for(int i=0;i<n;i++)
		{
			v[i][0] = age.get(i);
			v[i][1] = skill.get(i);
		}

		Arrays.sort(v , new Comparator<int[]>()
		{
			public int compare(int[] first , int[] second)
			{
				if(first[0] != second[0]) return first[0]-second[0];

				return first[1] - second[1];
			}
		});

		int[] dp = new int[n];

		for(int i=0;i<n;i++)
		{
			dp[i] = v[i][1];
		}


		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (v[i][0] == v[j][0]) {
					dp[i] = Math.max(dp[i], dp[j] + v[i][1]);
				} else if (v[i][1] >= v[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + v[i][1]);
				}
			}

			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}
}