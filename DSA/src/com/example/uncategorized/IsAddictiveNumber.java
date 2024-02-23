package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/additive-number/

public class IsAddictiveNumber {
	public boolean isAdditiveNumber(String num) {
		return helper(0 , num , new ArrayList<>());
	}

	boolean helper(int index , String num , List<String> result)
	{
		if(index == num.length() && result.size() >= 3) return true;

		for(int i= index ; i<num.length(); i++)
		{
			if( i != index && num.charAt(index) == '0') break;

			String currNum = num.substring(index , i+1);

			if (result.size() <= 1 || currNum.equals(
					String.valueOf(
							Long.parseLong(result.get(result.size() - 1)) 
							+ Long.parseLong(result.get(result.size() - 2)))

					))
			{
				result.add(currNum);
				if(helper(i+1 , num , result)) return true;

				result.remove(result.size()-1);
			} 

		}

		return false;
	}
}