package com.example.ciscopractice;

import java.util.*;

public class AllIntegerPermutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] freq = new int[nums.length];
        solve(nums ,freq , new ArrayList<>() , result);

        return result;
    }

    void solve(int[] nums , int[] freq , List<Integer> list , List<List<Integer>> result)
    {
        if(list.size() == nums.length)
        {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(freq[i] == 0)
            {
                list.add(nums[i]);
                freq[i]=1;
                solve(nums , freq , list,result);
                freq[i]=0;
                list.remove(list.size()-1);
            }
        }
    }
}