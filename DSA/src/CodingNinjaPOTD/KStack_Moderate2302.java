package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/anish-and-stacks_2687877
// Microsoft

public class KStack_Moderate2302 {

	public static int[] k_stack(int l, int n, int q, int[][] queries) {

		// Write your code here
		Map<Integer,Stack<Integer>> map = new HashMap<>();
		int[] res = new int[q];
		int index = 0;

		for(int[] que : queries)
		{
			int ops = que[0];
			int sta = que[1];

			if(ops == 1)
			{
				int val = que[2];
				res[index] = 0;
				Stack<Integer> stack = new Stack<>();
				if(map.containsKey(sta)) stack = map.get(sta);
				stack.push(val);
				map.put(sta , stack);
			}
			else
			{
				if(! map.containsKey(sta)) res[index] = -1;
				else
				{
					Stack<Integer> stack = map.get(sta);
					res[index] = stack.pop();
					if(stack.isEmpty()) map.remove(sta);
					else map.put(sta , stack);                    
				}
			}

			index++;
		}

		return res;
	}
}