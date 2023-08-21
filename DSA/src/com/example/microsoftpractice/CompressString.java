package com.example.microsoftpractice;

public class CompressString {
	public int compress(char[] chars) {
		if(chars.length==1) return 1;
		StringBuilder sb = new StringBuilder();

		char ch = chars[0];
		int count =0;
		for(int i=1;i<chars.length;i++)
		{
			if(chars[i] == ch)count++;
			else
			{
				if(count == 0) sb.append(ch);
				else
				{
					sb.append(ch).append(count+1);
				}
				ch=chars[i];
				count=0;
			}
		}

		//handle the last count
		if(count == 0) sb.append(ch);
		else
		{
			sb.append(ch).append(count+1);
		}
		return sb.length();
	}

	public static String compressTheString(String s) {
		// Write your code here
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		for(int i=0;i<n;i++)
		{
			int count = 1 ;

			while(i+1 < n && s.charAt(i) == s.charAt(i+1))
			{
				i++;
				count++;
				if(i>=n) break;
			}
			if(count>1)
			{
				sb.append(s.charAt(i-1)).append(count);

			} 
			else sb.append(s.charAt(i));
		}

		return sb.toString();
	}
}