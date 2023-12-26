package com.example.apple;
// https://leetcode.com/problems/longest-uncommon-subsequence-ii/

public class UnCommonLengthSubsequence {
    public int findLUSlength(String[] strs) {
        int max = -1;

        for(int i = 0; i<strs.length ; i++)
        {
            boolean isUncommon = true;
            for(int j=0;j<strs.length;j++)
            {
                if(i != j && isSubSequence(strs[i] , strs[j]))
                {
                    isUncommon = false;
                    break;
                }
            }

            if(isUncommon) max = Math.max(max , strs[i].length());
        }
        return max;
    }

    boolean isSubSequence(String s1 , String s2)
    {
        int i = 0;
        int j = 0;

        while(i<s1.length() && j<s2.length())
        {
            if(s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }

        return i == s1.length();
    }
}