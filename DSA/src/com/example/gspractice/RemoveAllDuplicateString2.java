package com.example.gspractice;

import java.util.Stack;

public class RemoveAllDuplicateString2 {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for(char c : ch)
        {
            if(stack.isEmpty() || stack.peek()[0] != c) stack.push(new int[]{c,1});
            else if(stack.peek()[0] == c)
            {
                if(stack.peek()[1] == k-1)
                {
                    int i = k-1;
                    while(i-- != 0) stack.pop();
                }
                else stack.push(new int[]{c , stack.peek()[1]+1});
            }
        }

        String res = "";
        for(int[] a :stack)  res = res+(char)(a[0]);
        return res;
    }
}