package com.example.googlepractice;

import java.util.*;

public class AllIntegerPermutation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = permute(new int[] {2,3,4,6,2});
		System.out.println(result);
	}
	
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] freq = new int[nums.length];
        solve(nums ,freq , new ArrayList<>() , result);

        return result;
    }

    static void solve(int[] nums , int[] freq , List<Integer> list , List<List<Integer>> result)
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