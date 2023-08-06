package com.example.gspractice;

import java.util.*;

public class LargestPossibleNumber {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i:nums) list.add(String.valueOf(i));
        Collections.sort(list , new Comparator<String>()
        {
             @Override 
            public int compare(String a , String b)
            {
                String x = a+b;
                String y = b+a;


                return x.compareTo(y) > 0 ? -1 : 1;
            }
        }
        );

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            sb.append(list.get(i));
        }
        int point = 0;

        for(int i =0 ; i<sb.length();i++)
        {
            if(sb.charAt(i)=='0') point++;
            else break;
        }
        if(point == sb.length()) return "0";
        return sb.toString();
    }
}