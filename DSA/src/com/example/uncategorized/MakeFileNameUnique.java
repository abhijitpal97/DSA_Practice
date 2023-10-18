package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/making-file-names-unique/description/

public class MakeFileNameUnique {
	public String[] getFolderNames(String[] names) {
		Map<String , Integer> unique = new HashMap<>();

		for(int i=0;i<names.length;i++)
		{
			String name = names[i];

			int count = unique.getOrDefault(name , 0);

			while(unique.containsKey(name))
			{
				name = names[i]+"("+ ++count+")";
			}

			unique.put(names[i] , count);
			unique.put(name , 0);

			names[i] = name;
		}

		return names;
	}
}