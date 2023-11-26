package com.example.oracle;

import java.util.*;

// https://leetcode.com/problems/time-based-key-value-store/description/

class TimeBasedComparePair implements Comparable<TimeBasedComparePair>
{
	String val;
	int timestamp;

	TimeBasedComparePair(String val, int timestamp)
	{
		this.val = val;
		this.timestamp=timestamp;

	}

	public int compareTo(TimeBasedComparePair that)
	{
		return this.timestamp - that.timestamp;
	}

}

public class TimeMap {
	Map<String , List<TimeBasedComparePair>> map;
	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if(map.containsKey(key)) map.get(key).add(new TimeBasedComparePair(value , timestamp));
		else map.put(key , new ArrayList<>(Arrays.asList(new TimeBasedComparePair(value , timestamp))));
	}

	public String get(String key, int timestamp) {
		if(map.containsKey(key))
		{
			List<TimeBasedComparePair> list = map.get(key);
			int start = 0;
			int end = list.size()-1;
			String res = "";
			if(list.get(start).timestamp > timestamp) return "";
			if(list.get(end).timestamp <= timestamp) return list.get(end).val;

			while(start<=end)
			{
				int mid = (start+end)/2;
				int timeVal = list.get(mid).timestamp;
				if(timeVal == timestamp) return list.get(mid).val;
				else if(timeVal<timestamp)
				{
					res = list.get(start).val;
					start = mid+1;
				}
				else end = mid-1;
			}
			return res;            
		}
		else return "";
	}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */