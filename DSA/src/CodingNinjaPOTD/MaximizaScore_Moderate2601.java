package CodingNinjaPOTD;
import java.util.*;

// https://www.codingninjas.com/studio/problems/maximize-score_1229509
public class MaximizaScore_Moderate2601 {
	public static int maximizeScore(ArrayList<Integer> arr, int n, int k) {
		//Write your code here

		int sum = 0;
		for(int i : arr) sum += i;

		int min = sum;

		for(int i=0;i<=k;i++)
		{
			int curr = 0;

			for(int j = i; j<i+n-k ; j++)
			{
				curr += arr.get(j);
			}

			min = Math.min(min , curr);
		}

		return sum-min;

	}
}

