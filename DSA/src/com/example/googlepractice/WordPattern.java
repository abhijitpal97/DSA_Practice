package com.example.googlepractice;

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map=new HashMap<>();
        String[] words = s.split("\\s+");
        if(pattern.length() !=words.length) return false;
        for(int i=0;i<words.length;i++)
        {
            if(map.containsKey(pattern.charAt(i)))
            {
                String word = map.get(pattern.charAt(i));
                if(! word.equals(words[i].trim())) return false;
            }
            else
            {
                if(map.containsValue(words[i].trim()))
                    return false;
                map.put(pattern.charAt(i),words[i].trim());
            }

        }
        return true;
    }
}