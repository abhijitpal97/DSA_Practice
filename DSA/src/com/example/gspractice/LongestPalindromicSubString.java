package com.example.gspractice;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for(int i = 0 ; i<s.length() ; i++)
        {
            int l1 = palindromicLength(s , i , i);
            int l2 = palindromicLength(s , i , i+1);
            int len = Math.max(l1,l2);
            if(len > end - start)
            {
                start = i- (len-1)/2;
                end = i+(len/2);
            }
        }

        return s.substring(start , end+1);
    }
    int palindromicLength(String s , int start , int end)
    {
        if(s==null || s.length() == 0 || start>end) return 0;
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;
        }
        return end-start-1;
    }
}