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
}