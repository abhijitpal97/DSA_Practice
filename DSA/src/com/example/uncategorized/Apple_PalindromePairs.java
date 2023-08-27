package com.example.uncategorized;

import java.util.*;

public class Apple_PalindromePairs {
	
	// Brute Force - TC -> n^2
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i <words.length ; i++)
        {
            for(int j = 0 ; j < words.length ; j++)
            {
                if(i != j) 
                {
                    String str = words[i]+words[j];
                    if(isPalindrome(str , 0 , str.length()-1)) list.add(new ArrayList<>(Arrays.asList(i , j)));
                }
                
            }
        }

        return list;
    }

    boolean isPalindrome(String str , int start , int end)
    {
        //System.out.println(str);
        while(start<end)
        {
            if(str.charAt(start) == str.charAt(end))
            {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}