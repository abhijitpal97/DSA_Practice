package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/hills-and-watchmen_5526027

public class HillsAndSoldier_Moderate2212 {
	public static int countPairs(int n, int[] hills) {
		// Write your code here.
		Stack<int[]> stack = new Stack<>();
		int count =0;


		for(int i=0;i<n;i++)
		{
			while(! stack.isEmpty() && stack.peek()[0]<hills[i])
			{
				count += stack.peek()[1];

				stack.pop();
			}

			if(stack.isEmpty()) stack.push(new int[]{hills[i] , 1});
			else if(stack.peek()[0] == hills[i])
			{
				count += stack.peek()[1];

				if(stack.size()>1) count++;

				int[] curr = stack.pop();
				curr[1] = curr[1]+1;

				stack.push(curr);
			}

			else
			{
				count++;
				stack.push(new int[]{hills[i] , 1});
			}


		}

		return count;
	}
}