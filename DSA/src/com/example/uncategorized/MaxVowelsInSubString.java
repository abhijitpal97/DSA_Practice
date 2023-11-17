package com.example.uncategorized;

import java.util.*;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

public class MaxVowelsInSubString {
    public int maxVowels(String s, int k) {
        List<Character> list = new ArrayList<>(Arrays.asList('a','e','i','o','u'));

        int n = s.length();

        int max = 0;
        int start = 0;
        int curr = 0;

        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(list.contains(ch)) curr++;
            if(k == i-start+1)
            {
                max = Math.max(curr , max);
                char ch1 = s.charAt(start);
                if(list.contains(ch1)) curr--;
                start++;
            }
        }

        return max;
    }
}