package LeetCodePOTD;
// https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/

public class LargestGoodInteger {
	public String largestGoodInteger(String num) {
		if(num.length() <3) return "";

		int max = -1;
		for(int i=2;i<num.length();i++)
		{
			char c1 = num.charAt(i-2);
			char c2 = num.charAt(i-1);
			char c3 = num.charAt(i);

			StringBuilder curr = new StringBuilder();
			if(c1==c2 && c2==c3)
			{
				curr = curr.append(c1).append(c2).append(c3);
				max = Math.max(max , Integer.valueOf(curr.toString()));
			}
		}

		if(max == -1) return "";
		if(max == 0) return "000";
		return String.valueOf(max);
	}
}