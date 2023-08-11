package com.example.googlepractice;

import java.util.*;

public class CowsAndBulls {
    public String getHint(String secret, String guess) {
        int cows = 0;
        int bulls = 0;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0 ; i<secret.length();i++)
        {
            if(secret.charAt(i) == guess.charAt(i)) cows++;
            else
            {
                char c1 = secret.charAt(i);
                char c2 = guess.charAt(i);
                map1.put(c1 , map1.getOrDefault(c1,0)+1);
                map2.put(c2 , map2.getOrDefault(c2,0)+1);
            }
        }

        for(Map.Entry<Character,Integer> m1 : map1.entrySet())
        {
            if(map2.containsKey(m1.getKey())) bulls += Math.min(m1.getValue() , map2.get(m1.getKey()));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cows).append("A");
        sb.append(bulls).append("B");

        return sb.toString();
    }
}