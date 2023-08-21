package com.example.microsoftpractice;
import java.util.* ;
import java.io.*; 

public class ReArrangeArray {

	public static void main(String[] args)
	{
		ArrayList<Integer> list = 
				rearrange(new ArrayList<>(Arrays.asList(10,10)));
		System.out.println(list);
	}

	public static ArrayList<Integer> rearrange(ArrayList<Integer> num) {
		// Write you code here.
		Queue<int[]> queue = new PriorityQueue<>((a,b) -> b[1] - a[1]);
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : num) map.put(i , map.getOrDefault(i , 0)+1);
		for(Map.Entry<Integer,Integer> m1: map.entrySet())
		{
			queue.offer(new int[]{m1.getKey() , m1.getValue()});
		} 

		ArrayList<Integer> list = new ArrayList<>();
		while(!queue.isEmpty())
		{
			int[] first =queue.poll();
			if(queue.isEmpty() && first[1]>1) return new ArrayList<>();
			if(queue.isEmpty() && first[1]==1)
			{
				list.add(first[0]);
				return list;
			}

			int[] second = queue.poll();
			if(first[1]>1) queue.offer(new int[]{first[0] , first[1] - 1});
			if(second[1]>1) queue.offer(new int[]{second[0] , second[1] - 1});

			list.add(first[0]);
			list.add(second[0]);


		}
		return list;
	}
}