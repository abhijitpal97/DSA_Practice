package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/sort-vowels-in-a-string/

public class SortVowelsInString {
	public static void main(String[] args)
	{
		String res = sortVowels("lEetcOde");
		System.out.println(res);
	}
	public static String sortVowels(String s) {
		char[] chs = s.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		Set<Character> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();
		int index = 0;
		List<Character> vowels = new ArrayList<>(Arrays.asList(
				'a','A','e','E','i','I','o','O','u','U'));
		for(int i = 0 ; i<s.length() ; i++)
		{
			char ch = s.charAt(i);
			if(vowels.contains(ch))
			{
				map.put(ch , map.getOrDefault(ch , 0)+1);
				set.add(ch);
				list.add(i);
			}
		}

		for(char ch : set)
		{
			int count = map.get(ch);

			while(count != 0)
			{
				chs[list.get(index)] = ch;
				index++;
				count--;
			}
		}

		return new String(chs);
	}
}