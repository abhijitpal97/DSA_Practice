package com.example.amazonpractice;

import java.util.*;

public class ReplaceWordsFromDictionary {
	public String replaceWords(List<String> dictionary, String sentence) {
		Collections.sort(dictionary);
		String[] splitted = sentence.split("\\s");

		for(String str : dictionary)
		{
			for(int i = 0 ; i<splitted.length;i++)
			{
				int index = splitted[i].indexOf(str);
				if(index == 0)
				{
					splitted[i] = str;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for(String str : splitted) sb.append(str).append(" ");

		sb.setLength(sb.length()-1);
		return sb.toString();
	}
}