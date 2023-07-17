package com.example.googlepractice;

import java.util.Stack;

public class PolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                int a = stack.pop();
                int b = stack.pop();
                int sum = b+a;
                stack.push(sum);
            }
            else if(tokens[i].equals("-"))
            {
                int a = stack.pop();
                int b = stack.pop();
                int min = b-a;
                stack.push(min);
            }
            else if(tokens[i].equals("*"))
            {
                int a = stack.pop();
                int b = stack.pop();
                int mul = b*a;
                stack.push(mul);
            }
            else if(tokens[i].equals("/"))
            {
                int a = stack.pop();
                int b = stack.pop();
                int div = b/a;
                stack.push(div);
            }
            else stack.push(Integer.valueOf(tokens[i]));
        }

        return stack.pop();

    }
}