package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/longest-prefix-which-is-suffix_3146849

public class LongestPrefixSuffix_Moderate1809 {

	public static void main(String[] args)
	{
		String res = longestPrefixSuffix("aaaaabaa");
		System.out.println(res);
	}

	public static String longestPrefixSuffix(String str){
		// Write your code here.
		int start = 0;
		int end = str.length()-1;
		String result = "";
		while(start<end)
		{
			String suffix = str.substring(0 , start+1);
			String prefix = str.substring(end-start);

			if(prefix.equals(suffix)) result = suffix;
			start++;
		}

		return result;
	}
}