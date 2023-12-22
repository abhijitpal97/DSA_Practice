package LeetCodePOTD;

// https://leetcode.com/problems/maximum-score-after-splitting-a-string

public class MaxScore_2212 {
	public int maxScore(String s) {
		int zero = 0;
		int one = 0;
		int ans = Integer.MIN_VALUE;

		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == '0') zero++;
			else one++;

			if(i != s.length()-1) ans = Math.max(ans , zero-one);
		}
		return ans+one;
	}
}