package com.example.googlepractice;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String s1 = strs[0];
        if(strs.length==1)
            return strs[0];
        else
        {
            for(int i = 1 ; i<strs.length ; i++)
            {
                s1 = compare(s1 , strs[i]);
            }
        }
        return s1;
    }
    
    public String compare(String s1 , String s2)
    {
        int lastIndex =0 ;
        boolean flag =true;
        int leng = s1.length()>s2.length()?s2.length():s1.length();
        for(int i =0; i< leng ; i++)
        {
            if(s1.charAt(i) == s2.charAt(i))
            {
                lastIndex++;
            }
            else
            {
                flag = false;
                break;
            }
            if(flag == false)
                break;
        }
        
        System.out.println(s1.substring(0,lastIndex));
        return s1.substring(0,lastIndex);
    }
}