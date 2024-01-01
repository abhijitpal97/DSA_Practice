package LeetCodePOTD;
// https://leetcode.com/problems/assign-cookies/submissions/1133585374

import java.util.Arrays;

public class AssignCookies_0101 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int i = 0;

		for(int j=0; i<g.length && j<s.length ; j++)
		{
			if(g[i]<=s[j]) i++;
		}

		return i;
	}
}