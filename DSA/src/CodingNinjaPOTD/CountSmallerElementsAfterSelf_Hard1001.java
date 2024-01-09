package CodingNinjaPOTD;
import java.util.*;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/

public class CountSmallerElementsAfterSelf_Hard1001 {
	public static void main(String[] args)
	{
		int[] res = countNumber(4, new int[] {4,1,2,5});

		for(int i : res) System.out.println(i);
	}
	public static int[] countNumber(int n, int[] arr) {
		// Write your code here.
		// 4 2 1 5
		// 1 2 4 5
		List<Integer> list = new ArrayList<>();
		for(int i : arr) list.add(i);
		Collections.sort(list);
		int[] res = new int[n];

		for(int i=0;i<n;i++)
		{
			int value = arr[i];
			int index = findSmaller(value , list ,0 , list.size());

			list.remove(index);

			int count = find(value , list , index);

			res[i] = count;
		}

		return res;
	} 

	static int findSmaller(int val , List<Integer> list , int start , int end)
	{
		while(start<=end)
		{
			int mid = start+(end-start)/2;
			int x = list.get(mid);
			if(val == x) return mid;
			if(val>x) start = mid+1;
			else if(val<x) end = mid-1;
		}
		return -1;
	}

	static int find(int val , List<Integer> list , int pos)
	{
		for(int i=pos-1 ; i>=0 ; i--)
		{
			int curr = list.get(i);
			if(curr<val) return i+1;
		}
		return 0;
	}
}