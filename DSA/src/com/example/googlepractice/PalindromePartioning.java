package com.example.googlepractice;

import java.util.*;

public class PalindromePartioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        function(s , new ArrayList<>() , result);
        return result;
    }

    void function(String s , List<String> list ,List<List<String>> result)
    {
        if(s.length()==0)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<s.length();i++)
        {
            if(isPalindrome(s.substring(0,i+1)))
            {
                list.add(s.substring(0 , i+1));
                function(s.substring(i+1) , list, result);
                list.remove(list.size()-1);
            }
        }
        
    }

    boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length()-1;

        while(start<end)
        {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}