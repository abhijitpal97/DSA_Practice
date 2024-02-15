package CodingNinjaPOTD;
/*
    Time Complexity: O(N+M)
    Space Complexity: O(N)

    Where 'N' is the number of elements in the array 'arr' and 
    'M' is the number of challenges that Emma gave to Ninja.
 */

import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/eat-favourite-pizza-on-given-day_1474979
// Amazon

public class EatFavouritePizza_Moderate1502
{
	public static ArrayList<Integer> canCompleteChallenges(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> mat)
	{
		int n = arr.size();
		int m = mat.size();

		// Array for prefix sum
		ArrayList<Integer> prefixSum = new ArrayList<Integer>();

		prefixSum.add(arr.get(0));

		for (int i = 1; i < n; i++)
		{
			prefixSum.add(prefixSum.get(i - 1) + arr.get(i));
		}

		// Array for storing the final answer
		ArrayList<Integer> answer = new ArrayList<Integer>();

		// Finding for the challenges individually
		for (int i = 0; i < m; i++)
		{
			int currentType = mat.get(i).get(0);
			int currentDay = mat.get(i).get(1);
			int maxConsumption = mat.get(i).get(2);

			// Condition 1
			int minimumDaysRequired;
			if (currentType == 0)
			{
				minimumDaysRequired = 0;
			}

			else
			{
				minimumDaysRequired = prefixSum.get(currentType - 1) / maxConsumption;
			}

			// Condition 2
			int maximumDaysRequired;

			maximumDaysRequired = prefixSum.get(currentType) - 1;

			// Checking for both the conditions
			if (currentDay >= minimumDaysRequired && currentDay <= maximumDaysRequired)
			{
				answer.add(1);
			}

			else
			{
				answer.add(0);
			}
		}

		// Return the final answer
		return answer;
	}
}

