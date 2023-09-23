package com.example.amazonpractice;

import java.util.*;

public class ProcessExecutorMaxEqualPriorityElemenate
{
	public static void main(String[] args) {
		int[] process = new int[] {6,1,2,6,6,2};
		List<Integer> list = getPrioritiesAfterExecution(process);
		System.out.println(list);


	}

	public static List<Integer> getPrioritiesAfterExecution(int[]nums) {
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		while(!map.containsKey(0)){
			for(int i=0;i<nums.length;i++) {
				if(nums[i]!=Integer.MIN_VALUE){
					ArrayList<Integer> indexList = map.getOrDefault(nums[i],new ArrayList<Integer>());
					indexList.add(i);
					map.put(nums[i],indexList);
					if(indexList.size()>1){
						heap.add(nums[i]);
					}
				}
			}
			if(heap.size()==0){
				break;
			}
			Integer maxPriority = heap.poll();
			if (maxPriority != null){
				int firstIndex = map.get(maxPriority).get(0);
				nums[firstIndex] = Integer.MIN_VALUE;
				int secondIndex = map.get(maxPriority).get(1);
				nums[secondIndex] = nums[secondIndex]/2;
			}
			map.clear();
			heap.clear();
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int num: nums){
			if(num!=Integer.MIN_VALUE){
				ans.add(num);
			}
		}

		return ans;
	}

}