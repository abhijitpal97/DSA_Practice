package LeetCodePOTD;

// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent

public class ArrayStringEquivalent_0112 {

	public static void main(String[] args)
	{
		boolean res = arrayStringsAreEqual(new String[] {"ab", "c"},
				new String[] {"a", "bc"});
		System.out.println(res);
	}
	public static  boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder sb = new StringBuilder();
		for(String str : word1) sb.append(str);

		String word = sb.toString();
		for(String str : word2)
		{
			if(word.indexOf(str) != 0) return false;
			word = word.substring(str.length());
		}
		if(word.length()>0) return false;

		return true;
	}
}