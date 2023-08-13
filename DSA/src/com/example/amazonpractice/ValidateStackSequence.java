package com.example.amazonpractice;

import java.util.Stack;

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
     Stack<Integer> stack = new Stack<>();
     int poI = 0;
     int n = pushed.length;

     for(int i=0;i<n;i++)
     {
         stack.push(pushed[i]);
         while(! stack.isEmpty() && stack.peek() == popped[poI])
         {
             poI++;
             stack.pop();
         }
     }

     while(! stack.isEmpty())   
     {
         if(stack.peek() == popped[poI])
         {
             poI++;
             stack.pop();
         }
         else return false;
     }

     return true;
    }
}