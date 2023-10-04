package com.example.apple;

// https://leetcode.com/problems/lemonade-change/

public class LemonadeChange {
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0 ;
		for(int bill : bills)
		{
			if(bill == 5) five++;
			else if(bill == 10)
			{
				if(five == 0) return false;
				else
				{
					ten++;
					five--;
				}
			}
			else if(bill == 20)
			{
				if(five == 0) return false;
				if(ten == 0 && (five<3)) return false;                
				else
				{
					if(ten != 0 && five != 0)
					{
						ten--;
						five--;
					}
					else if(ten == 0) five -=3;
				}
			}
		}
		return true;

	}
}