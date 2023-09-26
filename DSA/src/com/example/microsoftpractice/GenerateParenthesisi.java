package com.example.microsoftpractice;

import java.util.*;

// https://leetcode.com/problems/generate-parentheses/description/

public class GenerateParenthesisi {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(n , n , list , "");
        return list;
    }

    void helper(int start , int end , List<String> list,String str)
    {
        if(start == 0 && end == 0)
        {
            list.add(str);
        }
        
        if(start<0) return;
        if(end<0) return;
        if(end<start) return;

        helper(start-1,end,list,str+'(');
        helper(start,end-1,list,str+')');
    }
}