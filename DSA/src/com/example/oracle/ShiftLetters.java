package com.example.oracle;

// https://leetcode.com/problems/shifting-letters/description/

public class ShiftLetters {
	public static void main(String[] args)
	{
		String res = shiftingLetters("mkgfzkkuxownxvfvxasy",
				new int[] {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513});
		System.out.println(res);
	}
	public static String shiftingLetters(String s, int[] shifts) {
		long total = 0;
		int n = shifts.length;
		int[] totalR = new int[n];
		for(int i : shifts) total += i; //17 14 9
		totalR[0] = (int)(total%26); // 17 
		for(int i=1;i<n;i++)
		{
			total -= shifts[i-1];
			totalR[i] = (int)(total%26);
		}

		StringBuilder sb = new StringBuilder();
		int index = 0;
		for(int i: totalR)
		{
			char ch = s.charAt(index);
			if(('z' - ch)<i)
			{
				i = i-('z'-ch)-1;
				ch ='a';
			}
			ch += i;
			index++;
			sb.append(ch);
		}

		return sb.toString();
	}
}