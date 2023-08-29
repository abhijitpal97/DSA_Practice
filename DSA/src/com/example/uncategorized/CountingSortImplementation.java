package com.example.uncategorized;

import java.util.*;

public class CountingSortImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Only Work with Positive Value
		// Should have a range

		int[] arr = new int[] {0,0,1,2,1,2,1,0,3,2,1,0,3,2,1,3,0};
		countSort(arr);

		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<arr.length;i++) sb.append(i).append(" ");
		System.out.println(sb);

	}

	private static void countSort(int[] arr) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i<arr.length ; i++)
		{
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}

		for(Map.Entry<Integer, Integer> m1 : map.entrySet())
		{
			int count = m1.getValue();
			int index = 0;
			while(count != 0 )
			{
				arr[index] = m1.getKey();
				index++;
				count--;
			}
		}
	}

}
