package StriverSheet175AndLoveBabbar450;

import java.util.*;

// https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1

public class FindDistinctSubstring {
    public int findSubString( String str) {
        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()) set.add(ch);
        
        int unique = set.size();
        int start = 0;
        int end = 0;
        int n = str.length();
        String res = "";
        int min=Integer.MAX_VALUE;
        
        Map<Character,Integer> map = new HashMap<>();
        
        while(end<n)
        {
            char ch = str.charAt(end);
            map.put(ch , map.getOrDefault(ch , 0)+1);
            
            while(map.size() == unique)
            {
                if(end-start+1<min)
                {
                    res = str.substring(start , end+1);
                    min = end-start+1;
                }
                
                char ch1 = str.charAt(start);
                map.put(ch1 , map.get(ch1)-1);
                if(map.get(ch1) == 0) map.remove(ch1);
                start++;
            }
            
            end++;
        }
        
        
        return min;
    }
}