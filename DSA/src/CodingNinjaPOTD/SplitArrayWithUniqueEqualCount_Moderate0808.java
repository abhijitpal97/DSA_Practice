package CodingNinjaPOTD;
import java.util.*;

public class SplitArrayWithUniqueEqualCount_Moderate0808 {
	static int count =0;
	public static int splitString(String s) {
		// Write your code here.
		count =0;
		Map<Character,Integer> map = new HashMap<>();

		for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);

		findUnique(s , map);
		return count;
	}

	static void findUnique(String str , Map<Character,Integer> map)
	{
		Map<Character,Integer> aux = new HashMap<>();

		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			map.put(ch,map.get(ch)-1);
			if(map.get(ch)==0) map.remove(ch);
			aux.put(ch , aux.getOrDefault(ch,0)+1);
			if(map.size() == aux.size()) count++;
			if(aux.size() > map.size()) break;
		}
	}
}