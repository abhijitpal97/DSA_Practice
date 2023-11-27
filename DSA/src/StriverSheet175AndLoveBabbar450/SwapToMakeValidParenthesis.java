package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/minimum-cost-to-make-string-valid_1115770

public class SwapToMakeValidParenthesis {
	public static void main(String[] args)
	{
		int res = findMinimumCost("{{{}");
		System.out.println(res);
	}
	public static int findMinimumCost(String str) {
		// Write your code here
		int n = str.length();
		if(n%2 == 1) return -1;
		Stack<Character> stack = new Stack<>();
		int min = 0;
		for(char ch : str.toCharArray())
		{
			if(stack.isEmpty())
			{
				if(ch == '}')
				{
					min++;
				}
				stack.push('}');
			}
			else
			{
				if(ch =='}') stack.pop();
				else if(ch == '{') stack.push('}');
			}
		}

		if(stack.isEmpty()) return min;

		int count = 0;
		while(! stack.isEmpty())
		{
			count++;
			stack.pop();
		}

		return (count/2)+min;

	}
}