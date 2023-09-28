package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/moderate_6581435?leftPanelTab=0

public class MinimumDeletionToAvoidRepeatingCharacters_Moderate2809 {
	public static int minimumCost(int n, String s, int[] cost) {
		// Write your code here.
		int total = 0;

		for(int i=0;i<n;i++)
		{
			int curr = cost[i];
			int min = cost[i];
			boolean flag = false;
			while(i+1<n && s.charAt(i) == s.charAt(i+1))
			{
				min = Math.max(min , cost[i+1]);
				curr += cost[i+1];
				i++;			
				flag = true;	
			}
			if(flag) total +=curr-min;

		}
		return total;
	}
}