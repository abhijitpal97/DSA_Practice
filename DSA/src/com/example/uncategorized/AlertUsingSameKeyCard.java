package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

public class AlertUsingSameKeyCard {
	
	public static void main(String[] args)
	{
		alertNames(new String[] {"daniel","daniel","daniel","luis","luis","luis","luis"}, 
				new String[] {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"});
	}
	
	public static List<String> alertNames(String[] keyName, String[] keyTime) {
		Map<String,List<String>> map = new HashMap<>();
		int n = keyName.length;
		for(int i=0;i<n;i++)
		{
			String key = keyName[i];
			String value = keyTime[i];
			if(map.containsKey(key)) map.get(key).add(value);
			else map.put(key , new ArrayList<>(Arrays.asList(value))); 
		}

		List<String> list = new ArrayList<>();
		for(Map.Entry<String , List<String>> m1 : map.entrySet())
		{
			List<String> curr = m1.getValue();
			Collections.sort(curr);
			int start = 0;
			int end = 2;
			int m = curr.size();

			while(end<m)
			{
				int currS = timeToMin(curr.get(start));
				int currE = timeToMin(curr.get(end));
				if(currE-currS<=60)
				{
					list.add(m1.getKey());
					break;
				}
				start++;
				end++;
			}
		}

		return list;
	}

	static int timeToMin(String time){
		String[] split = time.split(":");
		int HH = Integer.parseInt(split[0]);
		int MM = Integer.parseInt(split[1]);
		int HHToMin = HH * 60;
		int totalTimeInMin = HHToMin + MM;
		return totalTimeInMin;
	}
}