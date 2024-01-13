package LeetCodePOTD;

import java.util.*;
// https://leetcode.com/problems/determine-if-string-halves-are-alike

public class AlikeString_1201 {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        if(n%2 != 0) return false;
        int vw = 0;
        List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for(int i=0;i<n/2 ; i++)
        {
            char ch = s.charAt(i);
            if(list.contains(ch)) vw++;
        }
        for(int i = n/2 ; i<n ; i++)
        {
            char ch = s.charAt(i);
            if(list.contains(ch)) vw--;
            if(vw<0) return false;
        }

        if(vw>0) return false;
        return true;
    }
}