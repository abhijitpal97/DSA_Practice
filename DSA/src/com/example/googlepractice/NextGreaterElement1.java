package com.example.googlepractice;

import java.util.*;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=n-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                map.put(nums2[i],-1);
            }
            else
            {
                if(stack.peek()>nums2[i]) map.put(nums2[i] , stack.peek());
                else
                {
                    while(!stack.isEmpty() && stack.peek()<=nums2[i])
                    {
                        stack.pop();
                        if(stack.isEmpty()) map.put(nums2[i] , -1);
                    }
                    if(! stack.isEmpty()) map.put(nums2[i] , stack.peek());
                }
            }
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for(int i = 0 ; i<nums1.length ; i++)
        {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}