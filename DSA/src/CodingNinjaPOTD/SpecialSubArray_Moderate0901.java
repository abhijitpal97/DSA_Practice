package CodingNinjaPOTD;

import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problem-details/special-subarray_2825008

public class SpecialSubArray_Moderate0901 {

	static class Pair
	{
		int num ; 
		int count;

		Pair(int num , int count)
		{
			this.num = num;
			this.count = count;
		}
	}
	public static void main(String[] args)
	{
		int[] res = specialSubarray(3, new int[] {22,9,0});

		for(int i : res) System.out.println(i);
	}

	public static int[] specialSubarray(int n, int[] arr) {
		// Write your code here.
		Map<Integer,Integer> map = new LinkedHashMap<>();
		for(int i:arr) map.put(i, map.getOrDefault(i,0)+1);
		Queue<Pair> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
		Set<Integer> mf = new LinkedHashSet<>();
		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			pq.offer(new Pair(m1.getKey() , m1.getValue()));
		}
		int max = pq.peek().count;
		while(!pq.isEmpty() && pq.peek().count == max)
		{
			mf.add(pq.poll().num);
		}

		int min = Integer.MAX_VALUE;
		int fStart =0;
		int fEnd = n-1;
		for(Integer li : mf)
		{
			int start = 0;
			int end = n-1;
			while(arr[start] != li) start++;
			while(arr[end] != li) end--;
			int count = end-start+1;
			if(count<min)
			{
				fStart = start;
				fEnd = end;
				min = count;
			}
		}

		int[] res = new int[fEnd-fStart+1];
		int index=0;
		for(int i=fStart;i<=fEnd;i++) 
		{
			res[index] = arr[i];
			index++;
		}

		return res;


	}

}
