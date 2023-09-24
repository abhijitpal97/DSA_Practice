package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/find-the-duplicate-number/description/

public class AllDuplicateNumber {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
        {
            if(! set.add(i)) list.add(i);
        }

        return list;
    }
}