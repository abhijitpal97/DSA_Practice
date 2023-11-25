package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/html-entity-parser/

public class EntityParser {
	public static void main(String[] args)
	{
		String res = entityParser("and I quote: &quot;...&quot;");
		System.out.println(res);
	}
	public static String entityParser(String text) {
		Map<String,String> map = new HashMap<>();
		map.put("&quot;","\"");
		map.put("&apos;","'");
		map.put("&amp;","&");
		map.put("&gt;",">");
		map.put("&lt;","<");
		map.put("&frasl;","/");

		StringBuilder result = new StringBuilder();
		int left = 0, right, length = text.length();
		while(left < length){
			if(text.charAt(left) == '&'){
				right = left + 1;
				while(right < length && right - left < 6 && text.charAt(right) != ';'){
					right++;
				}
				String sub = text.substring(left, Math.min(right + 1, length));
				if(map.containsKey(sub)){
					result.append(map.get(sub));
					left = right + 1;
					continue;
				}
			}
			result.append(text.charAt(left++));
		}
		return result.toString();
	}
}