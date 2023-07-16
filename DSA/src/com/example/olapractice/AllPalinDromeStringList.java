package com.example.olapractice;

import java.util.*;

public class AllPalinDromeStringList 
{ 
    int palindromeSubStrs(String str) { 
        // code here      
        Set<String> palinDromeList = new HashSet<>();
        for(int i=0;i<str.length();i++)
        {
            String subStr = "";
            for(int j=i;j<str.length();j++)
            {
                subStr += str.charAt(j);
                if(isPalindrome(subStr)) palinDromeList.add(subStr);
            }
        }
        
        return palinDromeList.size();
    }
    
    boolean isPalindrome(String str)
    {
        int start = 0;
        int end = str.length()-1;
        
        while(start<end)
        {
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
} 