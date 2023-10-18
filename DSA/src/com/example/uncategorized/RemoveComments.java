package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/remove-comments/description/

public class RemoveComments {
	public List<String> removeComments(String[] source) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		boolean isCommented = false;

		for(String str : source)
		{
			for(int i = 0; i<str.length() ; i++)
			{
				if(isCommented)
				{
					if(str.charAt(i) == '*' &&
							i+1<str.length() && str.charAt(i+1) == '/')
					{
						isCommented = false;
						i++;
					}
				}
				else
				{
					if(str.charAt(i) == '/' && i+1<str.length() && str.charAt(i+1) == '/') break;
					else if(str.charAt(i) == '/' && i+1<str.length() && str.charAt(i+1) == '*')
					{
						isCommented = true;
						i++;
					}
					else
					{
						sb.append(str.charAt(i));
					}
				}
			}

			if(! isCommented && sb.length()>0)
			{
				list.add(sb.toString());
				sb = new StringBuilder();
			}
		}

		return list;
	}
}