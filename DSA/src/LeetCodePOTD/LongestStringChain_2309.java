package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/longest-string-chain/description/
//Google

public class LongestStringChain_2309 {
	public static void main(String[] args) {
		longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"});
	}

	public static int longestStrChain(String[] words) {
		Arrays.sort(words , (a,b) -> Integer.compare(a.length() , b.length()));
		HashMap<String , Integer> map = new HashMap<>();
		int res = 0;

		for(String word : words)
		{
			map.put(word , 1);

			for(int i=0;i<word.length();i++)
			{
				String curr = word.substring(0,i)+word.substring(i+1);

				if(map.containsKey(curr))
				{
					map.put(word , Math.max(map.get(word) , map.get(curr)+1));
				}
			}

			res = Math.max(res , map.get(word));
		}

		return res;
	}
}