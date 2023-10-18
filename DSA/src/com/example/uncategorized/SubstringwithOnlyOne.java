package com.example.uncategorized;

// https://leetcode.com/problems/number-of-substrings-with-only-1s/

public class SubstringwithOnlyOne {
    public int numSub(String s) {
        long count=0;
        int mod = 1000000007;
        int pos = 0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '1') 
            {
                pos++;
                count += pos;
            }
            else pos = 0;
        }

        return (int)(count%mod);
    }
}