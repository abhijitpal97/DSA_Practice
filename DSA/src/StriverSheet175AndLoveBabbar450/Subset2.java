package StriverSheet175AndLoveBabbar450;

import java.util.*;

// https://leetcode.com/problems/subsets-ii/submissions/1102689664/

public class Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		function(nums.length,nums,0,new ArrayList<>() , result);
		return result;
	}

	static void function(int n , int[] arr , int index , List<Integer> list , 
			List<List<Integer>> result)
	{
		List<Integer> temp = new ArrayList<>(list);
		Collections.sort(temp);
		if(! result.contains(temp))result.add(new ArrayList<>(temp));
		if(index >= n) return;

		list.add(arr[index]);
		function(n,arr,index+1,list,result);
		list.remove(list.size()-1);
		function(n,arr,index+1,list,result);
	}
}