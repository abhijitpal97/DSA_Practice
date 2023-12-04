package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/find-kth-element-from-product-array_1115786

public class KThSmallest_Hard0412 
{
	public static int kthSmallest(ArrayList<Integer> arr, int k) 
	{
		//Write your code here
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.size()-1;i++)
		{
			for(int j=i+1;j<arr.size();j++)
			{
				pq.offer(arr.get(i)*arr.get(j));
			}
		}

		if(k>pq.size()) return -1;
		while(k != 1)
		{
			pq.poll();
			k--;
		}

		return pq.peek();
	}
}
