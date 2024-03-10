package com.example.leetCode75;

// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.*;

public class IntersectionArrays_1003 {
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int n = nums1.length;
		int m = nums2.length;

		int i = 0;
		int j = 0;

		while(i<n && j<m)
		{
			if(nums1[i] == nums2[j])
			{
				if(! list.contains(nums1[i])) list.add(nums1[i]);
				i++;
				j++;
			}
			else if(nums1[i]>nums2[j]) j++;
			else i++;
		}

		int[] res = new int[list.size()];
		for(int k = 0; k<list.size() ; k++) res[k] = list.get(k);

		return res; 
	}
}