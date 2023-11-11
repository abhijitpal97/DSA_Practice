package com.example.uncategorized;

// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/description/

public class MinimumSwapToMakeAlternative {
    public int minSwaps(String s) {
        int ones = 0;
        int zeros = 0;

        for(char ch : s.toCharArray())
        {
            if(ch == '0') zeros++;
            else ones++;
        }

        if(Math.abs(zeros-ones) > 1) return -1;

        if(ones>zeros) return checkOne(s);
        if(zeros > ones) return checkZero(s);

        return Math.min( checkOne(s) , checkZero(s));
    }

    int checkOne(String str)
    {
        int swap = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length() ; i++)
        {
            if(i%2 == 0) sb.append('1');
            else sb.append('0');
        }
        String curr = sb.toString();
        //System.out.println(curr);
        for(int i=0; i<str.length() ; i++)
        {
            if(str.charAt(i) != curr.charAt(i)) swap++;
        }
        return swap/2;
    }

    int checkZero(String str)
    {
        int swap = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length() ; i++)
        {
            if(i%2 == 0) sb.append('0');
            else sb.append('1');
        }
        String curr = sb.toString();
       // System.out.println(curr);
        for(int i=0; i<str.length() ; i++)
        {
            if(str.charAt(i) != curr.charAt(i)) swap++;
        }
        return swap/2;
    }
}