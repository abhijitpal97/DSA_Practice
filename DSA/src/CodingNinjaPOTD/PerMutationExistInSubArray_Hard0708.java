package CodingNinjaPOTD;
import  java.util.*;

public class PerMutationExistInSubArray_Hard0708 {
	public static String permutationExist(String str1, String str2, int n, int m){
		// Write your code here.  
		if(str2.length()<str1.length()) return "No";
		Map<Character,Integer> map = new HashMap<>();
		for(char ch : str1.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);

		Map<Character,Integer> map1 = new HashMap<>();
		for(char ch : str2.toCharArray()) map1.put(ch , map1.getOrDefault(ch , 0)+1);

		for(Map.Entry<Character,Integer> m1 : map.entrySet())
		{
			char ch = m1.getKey();
			if(! map1.containsKey(ch)) return "No";
			if(m1.getValue() > map1.get(ch)) return "No";
		}

		return "Yes";

	}
}