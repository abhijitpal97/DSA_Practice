package com.example.amazonpractice;

import java.util.*;

public class ReverseSubstringBetweenPairParenthesis {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray())
        {
           if(ch != ')') stack.push(ch);
           else
           {
               StringBuilder sb = new StringBuilder();
               while(stack.peek() != '(') sb.append(stack.pop());
               stack.pop();
               for(int i = 0 ; i<sb.length();i++) stack.push(sb.charAt(i));
           } 
        }

        StringBuilder sb = new StringBuilder();
        while(! stack.isEmpty()) sb.insert(0 , stack.pop());
        
        return sb.toString();
    }
}