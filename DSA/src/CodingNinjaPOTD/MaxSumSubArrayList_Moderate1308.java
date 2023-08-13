package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

public class MaxSumSubArrayList_Moderate1308 {

	public static void main(String[] args)
	{
		maximumsumSubarray(4, new int[] {-11 , -1, -2, -55});
	}

	public static ArrayList<Integer> maximumsumSubarray(int n, int arr[]) {
		int maxSumSoFar = Integer.MIN_VALUE;
		int sumTill = 0;
		int posStart = 0;
		int posEnd = 0;
		int localStart = 0;

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			sumTill = sumTill+arr[i];

			if(sumTill>maxSumSoFar) 
			{
				maxSumSoFar = sumTill;
				posStart = localStart;
				posEnd = i;
			}
			else if(sumTill == maxSumSoFar)
			{
				if(posEnd - posStart < i - localStart)
				{
					posStart = localStart;
					posEnd = i;
				}
			}

			if(sumTill < 0)
			{
				sumTill = 0;
				localStart = i+1;
			}
		}

		for(int j = posStart ; j <=posEnd ; j++) list.add(arr[j]);

		return list;

	}
}
