package com.example.amazonpractice;

import java.util.*;

public class ReArrangeWordsByLength {
    public String arrangeWords(String text) {
        Map<Integer , List<String>> map = new TreeMap<>();
        String[] splits = text.split("\\s");
        for(String str : splits)
        {
           int length  = str.length();
           if(map.containsKey(length)) map.get(length).add(str.toLowerCase());
           else map.put(length , new ArrayList<>(Arrays.asList(str.toLowerCase())));
        }

        

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer , List<String>> m1 : map.entrySet())
        {
            for(String str : m1.getValue()) sb.append(str).append(" ");
        }

        sb.setLength(sb.length()-1);
        String res = sb.toString();
        res = sb.substring(0,1).toUpperCase()+sb.substring(1);
        return res;
    }
}