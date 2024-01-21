package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/find-players-with-zero-or-one-losses

class Player
{
	int win;
	int loss;

	Player(int win , int loss)
	{
		this.win = win;
		this.loss = loss;
	}
}



public class FindWinnersWithZeroAndOneLoss {
	public List<List<Integer>> findWinners(int[][] matches) {
		Map<Integer,Player> map = new HashMap<>();

		List<List<Integer>> list = new ArrayList<>();
		for(int[] match  : matches)
		{
			int p1 = match[0];
			int p2 = match[1];

			if(map.containsKey(p1))
			{
				Player play = map.get(p1);
				play.win++;
				map.put(p1 , play);
			}
			else
			{
				Player play = new Player(1,0);
				map.put(p1 , play);
			}


			if(map.containsKey(p2))
			{
				Player play = map.get(p2);
				play.loss++;
				map.put(p2 , play);
			}
			else
			{
				Player play = new Player(0,1);
				map.put(p2 , play);
			}
		}
		List<Integer> zeroLoss = new ArrayList<>();
		List<Integer> oneLoss = new ArrayList<>();

		for(Map.Entry<Integer,Player> m1 : map.entrySet())
		{
			Player play = m1.getValue();
			if(play.loss == 0) zeroLoss.add(m1.getKey());
			else if(play.loss == 1) oneLoss.add(m1.getKey());
		}
		Collections.sort(zeroLoss);
		Collections.sort(oneLoss);

		list.add(zeroLoss);
		list.add(oneLoss);

		return list;
	}
}