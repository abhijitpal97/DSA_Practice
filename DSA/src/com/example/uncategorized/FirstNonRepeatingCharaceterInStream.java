package com.example.uncategorized;

import java.util.*;

public class FirstNonRepeatingCharaceterInStream
{
	public String FirstNonRepeating(String A)
	{
		// code here
		int[] freq = new int[26];
		Queue<Character> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<A.length();i++)
		{
			char ch = A.charAt(i);
			queue.add(ch);
			freq[ch-'a']++;

			while(! queue.isEmpty() && freq[queue.peek()-'a']> 1) queue.poll();

			if(queue.isEmpty()) sb.append('#');
			else sb.append(queue.peek());
		}

		return sb.toString();
	}
}