package CodingNinjaPOTD;

import java.util.Stack;

// https://www.codingninjas.com/studio/problems/redundant-brackets_975473

public class DuplicateParenthesis_Moderate_0208 {

	public static void main(String[] args)
	{
		int res = checkRedundancy("((a+(b))+(c+d))");
		System.out.println(res);
	}

	public static int checkRedundancy(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == ')') {
				boolean foundOpening = false;
				while (!stack.isEmpty() && stack.peek() != '(') {
					char top = stack.pop();
					if (top == '+' || top == '-' || top == '*' || top == '/') {
						foundOpening = true;
					}
				}
				stack.pop(); // Pop the opening parenthesis itself
				if (foundOpening==false) {
					return 1; // Found redundant parenthesis
				}
			} else {
				stack.push(ch);
			}
		}

		return 0; // No redundant parenthesis found
	}
}