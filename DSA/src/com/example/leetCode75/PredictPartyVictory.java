package com.example.leetCode75;

import java.util.*;

// https://leetcode.com/problems/dota2-senate/

public class PredictPartyVictory {
	public String predictPartyVictory(String senate) {
		int n = senate.length();
		Queue<Integer> qR = new LinkedList<>();
		Queue<Integer> qD = new LinkedList<>();

		for(int i=0 ; i<n; i++)
		{
			char ch = senate.charAt(i);
			if(ch == 'R') qR.offer(i);
			else qD.offer(i);
		}

		while(! qR.isEmpty() && ! qD.isEmpty())
		{
			int cR = qR.poll();
			int cD = qD.poll();
			if(cR<cD) qR.offer(cR+n);
			else qD.offer(cD+n);
		}

		return qR.size()>qD.size()?"Radiant" : "Dire";
	}
}