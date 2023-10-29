package com.example.microsoftpractice;
import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/concert-tickets_1496516

public class ConcertTickets {

	public static void main(String[] args)
	{
		ArrayList<Integer> result = concertTickets(
				new ArrayList<>(Arrays.asList(1,2,3)),
				new ArrayList<>(Arrays.asList(2,2)));
		System.out.println(result);
	}

	public static ArrayList<Integer> concertTickets(ArrayList<Integer> price , ArrayList<Integer> pay) {
		// Write your code here.
		Collections.sort(price);
		ArrayList<Integer> result = new ArrayList<>();

		for(int i = 0 ; i<pay.size();i++)
		{
			binarySearch(price , pay.get(i) ,result);
		}
		return result;
	}

	static void binarySearch(ArrayList<Integer> prices , int target , ArrayList<Integer> result)
	{
		int start = 0 ;
		int end = prices.size()-1;
		int res = -1 ;
		int pt = -1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			int price = prices.get(mid);

			if(target<price) end = mid-1;
			else if(target>=price)
			{
				if(price > res)
				{
					res = price;
					pt = mid;
				}
				start = mid+1;
			}
		}
		if(res != -1) prices.remove(pt);

		result.add(res);
	}

}