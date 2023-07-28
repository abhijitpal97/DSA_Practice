package com.example.googlepractice;

import java.util.*;

public class AllIntegerPossibleSubset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        function(nums , 0 , new ArrayList<>() , result);
        return result;
    }

    void function(int[] nums , int index , List<Integer> list , List<List<Integer>> result)
    {
        if(index == nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[index]);
        function(nums, index+1 , list , result);
        list.remove(list.size()-1);
        function(nums , index+1 , list,result);
    }
}