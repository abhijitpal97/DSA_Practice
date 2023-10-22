package com.example.uncategorized;
import java.util.*;

// https://www.codingninjas.com/studio/problems/two-sum_839653
public class TwoSumExtended {
	public static void main(String[] args)
	{
		List<List<Integer>> res = twoSum
				(new ArrayList<>(Arrays.asList(1,2,2,1,2,1)), 3 , 6);
		System.out.println(res);
	}

	public static List<List<Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {
		// Write your code here.
		Map<Integer,Integer> map = new HashMap<>();
		List<List<Integer>> ans = new ArrayList<>();

		for(int i : arr) map.put(i , map.getOrDefault(i , 0)+1);


		for (int i = 0; i < n; i++) {
			if (target - arr.get(i) == arr.get(i)) {
				if (map.get(arr.get(i)) > 1) {
					ans.add(new ArrayList<>(Arrays.asList(arr.get(i), arr.get(i))));
					map.put(arr.get(i), map.get(arr.get(i)) - 2);
				}
			} else {
				if (map.containsKey(target - arr.get(i)) && map.get(arr.get(i)) > 0
						&& map.get(target - arr.get(i)) > 0) {

					ans.add(new ArrayList<>(Arrays.asList(arr.get(i), target - arr.get(i))));
					map.put(arr.get(i), map.get(arr.get(i)) - 1);
					map.put(target - arr.get(i), map.get(target - arr.get(i)) - 1);
				}
			}
		}

		if (ans.size() == 0)
			ans.add(new ArrayList<>(Arrays.asList(-1, -1)));

		return ans;
	}
}
