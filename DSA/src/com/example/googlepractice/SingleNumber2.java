package com.example.googlepractice;

import java.util.*;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }

        for(Map.Entry<Integer,Integer> m1 : map.entrySet())
        {
            if(m1.getValue() == 1) return m1.getKey();
        }

        return -1;
        
    }
}