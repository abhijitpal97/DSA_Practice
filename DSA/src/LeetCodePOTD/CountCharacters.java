package LeetCodePOTD;

import java.util.*;

public class CountCharacters {
	public static void main(String[] args)
	{
		int res = countCharacters(new String[]{"cat","bt","hat","tree"}, "atach");
		System.out.println(res);

	}
	public static int countCharacters(String[] words, String chars) {
		int count = 0;
		char[] allChars = new char[26];
		for(char ch : chars.toCharArray()) allChars[ch-'a']++;

		for(String str : words)
		{
			if(canForm(str , allChars)) count+= str.length();
		}

		return count;
	}

	static boolean canForm(String str , char[] chars)
	{
		char[] curr = chars.clone();

		for(char ch : str.toCharArray())
		{
			if(curr[ch-'a']==0) return false;
			curr[ch-'a']--;
		}

		return true;
	}
}