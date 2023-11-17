package CodingNinjaPOTD;
import java.util.*;

// https://www.codingninjas.com/studio/problems/ninja-and-the-workers_3169341

public class NonOverlappingReschedules_Moderate1711 {
	public static int minimumReschedules(int n, int[][] intervals) {
		// Write your code here.
		Arrays.sort(intervals , (a,b) -> a[0]-b[0]);
		int count = 0;
		int[] temp = intervals[0];

		for(int i=1;i<n;i++)
		{
			int[] curr = intervals[i];
			if(curr[0]<temp[1])
			{
				count++;
				temp[0] = Math.max(curr[0],temp[0]);
				temp[1] = Math.min(curr[1] ,temp[1]);
			}
			else
			{
				temp[0] = curr[0];
				temp[1] = curr[1];
			}
		}

		return count;
	}
}