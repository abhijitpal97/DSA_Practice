package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/invalid-transactions/

class Transaction
{
	String name;
	int time;
	int amount;
	String city;

	Transaction(String name , int time , int amount , String city)
	{
		this.name=name;
		this.time=time;
		this.amount=amount;
		this.city=city;
	}
}

public class InvalidTransaction {
	public List<String> invalidTransactions(String[] transactions) {
		Map<String , List<Transaction>> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		for(String trans : transactions)
		{
			String[] curr = trans.split(",");
			String name = curr[0];
			int time = Integer.parseInt(curr[1]);
			int amount = Integer.parseInt(curr[2]);
			String city = curr[3];

			if(map.containsKey(name))
			{
				map.get(name).add(new Transaction(name,time,amount,city));
			}
			else map.put(name , 
					new ArrayList<>(Arrays.asList(new Transaction(name,time,amount,city))));
		}

		for(String trans : transactions)
		{
			String[] curr = trans.split(",");
			String name = curr[0];
			int time = Integer.parseInt(curr[1]);
			int amount = Integer.parseInt(curr[2]);
			String city = curr[3];

			Transaction t = new Transaction(name,time,amount,city);

			List<Transaction> transList = map.get(t.name);

			if(! isValid(transList , t)) result.add(trans);
		}

		return result;
	}

	boolean isValid(List<Transaction> list , Transaction currT)
	{
		if(currT.amount > 1000) return false;

		for(Transaction t : list)
		{
			if(Math.abs(t.time-currT.time) <=60 && !currT.city.equals(t.city)) return false;
		}

		return true;
	}
}