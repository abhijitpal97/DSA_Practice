package LeetCodePOTD;

import java.util.*;

// https://leetcode.com/problems/find-unique-binary-string/submissions/1100135352/

public class FindUniqueBinaryString_1611 {
	boolean flag = false;
	String s = "";
	public String findDifferentBinaryString(String[] nums) {
		flag = false;
		Set<String> set = new HashSet<>();
		int n = nums[0].length();
		for(String str : nums) set.add(str);
		function(set , "0" , n-1);
		if(flag) return s;
		function(set , "1" , n-1);
		if(flag) return s;
		return "";
	}

	void function(Set<String> set ,String curr , int index)
	{
		if(index == 0)
		{
			if(! set.contains(curr))
			{
				flag = true;
				s = curr;
			}
			return;
		}
		if(flag) return;

		function(set , curr+"0" , index-1);
		function(set , curr+"1" , index-1);
	}
}