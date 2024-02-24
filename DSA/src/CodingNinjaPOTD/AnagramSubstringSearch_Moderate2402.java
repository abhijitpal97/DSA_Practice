package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/anagram-substring-search_873350

public class AnagramSubstringSearch_Moderate2402 {
	public static ArrayList<Integer> findAnagramsIndices(String str, String ptn, int n, int m) {
		// Write you code here.
		ArrayList<Integer> list = new ArrayList<>();
		if(m>n) return list;
		String sorted = sort(ptn);
		for(int i=0 ; i<=n-m ; i++)
		{
			String curr = sort(str.substring(i , i+m));
			if(sorted.equals(curr)) list.add(i);
		}

		return list;
	}

	static String sort(String str)
	{
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}