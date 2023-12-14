package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/three-in-one_1171171

public class ThreeInOneStack_Moderate1412 {
	public static void solve(int q, int[][] queries) {
		// Write your code here.
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Stack<Integer> stack3 = new Stack<>();

		for(int[] query : queries)
		{
			int st = query[0];
			int op = query[1];

			if(st == 0)
			{
				if(op == 0)
				{
					if(stack1.isEmpty()) System.out.println(-1);
					else System.out.println(stack1.pop());
				}
				else if(op == 1) stack1.push(query[2]);
			}

			else if(st == 1)
			{
				if(op == 0)
				{
					if(stack2.isEmpty()) System.out.println(-1);
					else System.out.println(stack2.pop());
				}
				else if(op == 1) stack2.push(query[2]);
			}

			else if(st == 2)
			{
				if(op == 0)
				{
					if(stack3.isEmpty()) System.out.println(-1);
					else System.out.println(stack3.pop());
				}
				else if(op == 1) stack3.push(query[2]);
			}
		}
	}
}