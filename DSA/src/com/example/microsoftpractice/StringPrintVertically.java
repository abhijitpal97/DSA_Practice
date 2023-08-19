package com.example.microsoftpractice;

import java.util.*;

public class StringPrintVertically {
	public List<String> printVertically(String s) {

		s = s.strip();
		String[] strs = s.split("\\s");
		int max = 0;
		for(String str : strs)
		{
			max = Math.max(max , str.length());
		}

		List<String> list = new ArrayList<>(max);
		for(int i=0; i<max;i++) list.add(i , "");
		for(String str : strs)
		{
			for(int i = 0 ; i<max ; i++)
			{
				char ch = i>=str.length()? ' ' : str.charAt(i);
				list.set(i , (list.get(i)+ch));
			}
		}

		for(int i=0; i<max;i++) list.set(i , list.get(i).stripTrailing());
		return list;

	}
}