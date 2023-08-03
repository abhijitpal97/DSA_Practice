package com.example.googlepractice;

import java.util.*;

public class RandomArrayShuffle {
    List<int[]> result;
    int[] cloneNum;
    int i=0;
    public RandomArrayShuffle(int[] nums) {
        result = new ArrayList<>();
        cloneNum = nums.clone();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) map.put(i , map.getOrDefault(i , 0)+1);
        generateAllPermutation(map , nums , result , new int[nums.length] , 0);
    }
    
    public int[] reset() {
        return cloneNum;
    }
    
    public int[] shuffle() {
        int[] res = result.get(i);
        i++;
        if(i == result.size()) i = 0;
        return res;
        
    }


    void generateAllPermutation(Map<Integer,Integer> map , int[] nums , List<int[]> result , 
    int[] list , int index)
    {
        if(index == nums.length)
        {
            result.add(list.clone());
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(map.get(nums[i]) == 0) continue;
            map.put(nums[i] , map.get(nums[i])-1);
            list[index] = nums[i];
            generateAllPermutation(map , nums , result , list , index+1);
            map.put(nums[i] , map.get(nums[i])+1);

        }
    }
}