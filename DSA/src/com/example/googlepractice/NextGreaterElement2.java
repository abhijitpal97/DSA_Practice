package com.example.googlepractice;

import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];
        for(int i= 2*n-1 ; i>=0;i--)
        {
            int index = i%n;
            while(!stack.isEmpty() && stack.peek()<=nums[index]) stack.pop();

            if(stack.isEmpty()) nge[index] = -1;
            else nge[index] = stack.peek();

            stack.push(nums[index]);
        }

        return nge;
    }
}