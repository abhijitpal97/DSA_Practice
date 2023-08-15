package com.example.amazonpractice;

import java.util.Stack;

public class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int result = 1;
        while(! stack.isEmpty() && stack.peek()[0]<=price)
        {
            result += stack.peek()[1];
            stack.pop();
        }
        
        stack.push(new int[]{price , result});
        return result;
    }
}