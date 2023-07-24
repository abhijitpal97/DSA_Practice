package com.example.googlepractice;

import java.util.*;

public class SortByCharacterFrequency {
    public String frequencySort(String s) {
     Map<Character,Integer> map = new HashMap<>();
     for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);
     Map<Character,Integer> sortedMap = sortMap(map);
     StringBuilder sb= new StringBuilder();
     for(Map.Entry<Character,Integer> m1 : sortedMap.entrySet())
     {
         int count = m1.getValue();
         while(count>0) 
         {
             sb.append(m1.getKey());
             count--;
         }
     }
     return sb.toString();   
    }

    public Map<Character,Integer> sortMap(Map<Character,Integer> map)
    {
        List<Map.Entry<Character,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list , new Comparator<Map.Entry<Character,Integer>>()
        {
            public int compare(Map.Entry<Character,Integer> o1 , Map.Entry<Character,Integer> o2)
            {
                return o2.getValue().compareTo(o1.getValue());
            }
        }
        );

        HashMap<Character,Integer> result  = new LinkedHashMap<>();
        
        for (Map.Entry<Character,Integer> me : list) {
            result.put(me.getKey(), me.getValue());
        }
 
        return result;
    }
}