package com.example.apple;

import java.util.*;

public class SimplifiedPath {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		Set<String> skip = new HashSet<>();
		skip.add("");
		skip.add(".");
		skip.add("..");

		String[] splits = path.split("/");

		for(String str : splits)
		{
			if(str.equals("..") && ! stack.isEmpty()) stack.pop();
			else if(! skip.contains(str)) stack.push(str);
		}

		while(! stack.isEmpty()) sb.insert(0 , stack.pop()).insert(0 , "/");

		return sb.isEmpty()?"/":sb.toString();
	}
}