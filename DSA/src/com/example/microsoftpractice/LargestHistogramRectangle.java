package com.example.microsoftpractice;

import java.util.Stack;

public class LargestHistogramRectangle {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        nextSmallerElement(heights , nse , n);
        prevSmallerElement(heights , pse , n);

        int largestRect = 0;
        for(int i = 0 ; i<n ; i++)
        {
            largestRect = Math.max(largestRect , Math.abs(nse[i] - pse[i] -1)*heights[i]);
        }

        return largestRect;
    }

    public void nextSmallerElement(int[] heights , int[] nse , int n)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1 ; i>=0;i--)
        {
            if(stack.isEmpty())
            {
                nse[i] = n;
            }
            else
            {
                if(heights[stack.peek()]<heights[i]) nse[i] = stack.peek();
                else
                {
                    while(heights[stack.peek()]>=heights[i])   
                    {
                        stack.pop();
                        if(stack.isEmpty()) break;
                    }
                    if(stack.isEmpty()) nse[i] = n;
                    else nse[i] = stack.peek();
                }
            }

            stack.push(i);
        }
    }

    public void prevSmallerElement(int[] heights , int[] pse , int n)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i<n ;i++)
        {
            if(stack.isEmpty())
            {
                pse[i] = -1;
            }
            else
            {
                if(heights[stack.peek()]<heights[i]) pse[i] = stack.peek();
                else
                {
                    while(heights[stack.peek()]>=heights[i])   
                    {
                        stack.pop();
                        if(stack.isEmpty()) break;
                    }
                    if(stack.isEmpty()) pse[i] = -1;
                    else pse[i] = stack.peek();
                }
            }

            stack.push(i);
        }
    }
}