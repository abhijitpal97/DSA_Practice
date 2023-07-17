package com.example.googlepractice;

import java.util.*;

public class FruitBasketLongest {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int max=0;
        Map<Integer,Integer> map = new HashMap<>();//  1 - 1; 2 - 1
        
        for(int i=0;i<fruits.length;i++)
        {
            map.put(fruits[i] , map.getOrDefault(fruits[i] , 0)+1);
            if(map.size() > 2)
            {
                while(map.size() != 2)
                {
                    int fr = fruits[start];
                    map.put(fr , map.get(fr)-1);
                    if(map.get(fr) == 0) map.remove(fr);
                    start++;
                }

            }
            else
            {
                max = Math.max(max , i-start+1);
            }
            
        }

        return max;
    }
}