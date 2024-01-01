package LeetCodePOTD;

import java.util.Arrays;

public class MaxLengthBetweenSubString_3112 {
	public static void main(String[] args)
	{
		int res = maxLengthBetweenEqualCharacters("abca");
		System.out.println(res);
	}
	public static int maxLengthBetweenEqualCharacters(String s) {
		int[] chars = new int[26];
		int max = -1;
		Arrays.fill(chars , -1);
		for(int i=0; i<s.length();i++)
		{
			char ch = s.charAt(i);
			int index = ch - 'a';
			if(chars[index] != -1)
			{
				max = Math.max(max , i-chars[index]-1);
			}
			else chars[index] = i;
		}

		return max;
	}
}