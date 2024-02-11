package com.example.amazonpractice;

import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/divide-chocolates_1466966?leftPanelTab=0

public class DivideChocholates {
	public static boolean checkValidity(ArrayList<Integer> arr, int k, int midSweetness)
	{
		int sumSweetness = 0, numberOfFriends = 0;

		// Iterating over the array.
		for (int currentSweetness : arr)
		{
			// Checking if after adding the current sweetness, it exceeds the target sweetness or not.
			if (sumSweetness + currentSweetness >= midSweetness)
			{
				sumSweetness = 0;
				numberOfFriends++;
			}
			else
			{
				sumSweetness += currentSweetness;
			}
		}

		// If the division is possible.
		if (numberOfFriends >= k)
		{
			return true;
		}
		return false;
	}

	public static int getMaximumSweetness(ArrayList<Integer> arr, int k) {
		int n = arr.size();

		if(k>=n)
		{
			return 0;
		}

		k++;

		int minSweetness = Integer.MAX_VALUE, maxSweetness = 0;
		for (int i = 0; i < n; i++)
		{
			minSweetness = Math.min(minSweetness, arr.get(i));
			maxSweetness += arr.get(i);
		}

		// Binary search over the range.
		while (maxSweetness > 1 + minSweetness)
		{
			int midSweetness = (minSweetness + maxSweetness) / 2;

			// If the current division is valid.
			if (checkValidity(arr, k, midSweetness))
			{
				minSweetness = midSweetness;
			}
			else
			{
				maxSweetness = midSweetness - 1;
			}
		}

		// If maxSweetness is taken as the answer and the division is possible.
		if (checkValidity(arr, k, maxSweetness))
		{
			return maxSweetness;
		}

		return minSweetness;

	}
}