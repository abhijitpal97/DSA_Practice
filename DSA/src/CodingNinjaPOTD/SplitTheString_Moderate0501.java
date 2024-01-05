package CodingNinjaPOTD;
import java.util.*;

// https://www.codingninjas.com/studio/problems/split-the-string_2280377

public class SplitTheString_Moderate0501 {
	public static int splitString(String s) {
		// Write your code here.
		Map<Character,Integer> map = new HashMap<>();
		for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch,0)+1);
		// a - 4; b - 1; d - 1 
		int count =0;
		Set<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			set.add(ch); // a b d
			map.put(ch , map.get(ch)-1); // a - 2; d - 1
			if(map.get(ch)==0) map.remove(ch);
			if(set.size() == map.size()) count++;			
		}

		return count;
	}
}