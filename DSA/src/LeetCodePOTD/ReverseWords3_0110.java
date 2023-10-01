package LeetCodePOTD;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

public class ReverseWords3_0110 {
	public String reverseWords(String s) {
		String[] strSplit = s.split("\\s");
		for(int i = 0 ; i<strSplit.length ; i++)
		{
			String str = strSplit[i];
			StringBuffer sb = new StringBuffer();
			for(int j=str.length()-1; j>=0 ; j--)
			{
				sb.append(str.charAt(j));
			}
			strSplit[i]=sb.toString();
		}

		StringBuffer sb = new StringBuffer();
		for(int i =0; i<strSplit.length; i++)
		{
			sb.append(strSplit[i]).append(" ");
		}

		sb.setLength(sb.length()-1);

		return sb.toString();
	}
}