package com.example.microsoftpractice;

import java.util.*;

public class TimeMap {
	Map<String  , Map<Integer,String>> map;
	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if(map.containsKey(key))
		{
			Map<Integer,String> curr = map.get(key);
			curr.put(timestamp , value);
		}
		else
		{
			Map<Integer,String> curr = new HashMap<>();
			curr.put(timestamp , value);
			map.put(key , curr);
		}
	}

	public String get(String key, int timestamp) {
		if(map.containsKey(key))
		{
			Map<Integer,String> curr = map.get(key);
			if(curr.containsKey(timestamp)) return curr.get(timestamp);
			else
			{
				String res = "";
				int t = Integer.MIN_VALUE;
				for(Map.Entry<Integer,String> m1 : curr.entrySet())
				{
					int c = m1.getKey();
					if(t<c && c<timestamp)
					{
						res = m1.getValue();
						t = c;
					}
				}
				return res;
			}
		}
		else return "";
	}
}