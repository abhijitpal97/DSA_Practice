package com.example.amazonpractice;

import java.util.Arrays;

//https://leetcode.com/problems/reorder-data-in-log-files/description/
public class ReOrderDataInLogFiles {

	public static void main(String[] args)
	{
		String[] result = reorderLogFiles(new String[] {"dig1 8 1 5 1","let1 art can",
				"dig2 3 6","let2 own kit dig","let3 art zero"});

		for(int i=0;i<result.length;i++)
		{
			System.out.println(result[i]);
		}
	}

	public static String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs , (a,b) ->
		{
			String[] first = a.split(" ");
			String[] second = b.split(" ");

			boolean isFirstNumber = Character.isDigit(first[1].charAt(0));
			boolean isSecondNumber = Character.isDigit(second[1].charAt(0));

			if(isFirstNumber && !isSecondNumber) return 1;
			if(!isFirstNumber && isSecondNumber) return -1;
			if(!isFirstNumber && !isSecondNumber)
			{
				int comparision = a.substring(first[0].length()).compareTo(b.substring(second[0].length()));

				if(comparision == 0) return first[0].compareTo(second[0]);
				return comparision;
			}

			return 0;
		});

		return logs;
	}
}