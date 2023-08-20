package CodingNinjaPOTD;

import java.util.Arrays;

public class NonOverlappingIntervals_Moderate2008 {
	public static int minimumReschedules(int n, int[][] intervals) {
		// Write your code here.
		Arrays.sort(intervals , (a,b) -> a[0] -b[0]);

		int[] temp = new int[2];
		temp[0] = intervals[0][0];
		temp[1] = intervals[0][1];
		int count = 0;
		for(int i=1; i<intervals.length ; i++)
		{
			if(intervals[i][0]<temp[1])
			{
				count++;
				if(intervals[i][1]<temp[1]) temp = intervals[i];
			}
			else
			{
				temp[0] = intervals[i][0];
				temp[1] = intervals[i][1];
			}
		}

		//System.out.println(n + " - "+count);
		return count;
	}
}