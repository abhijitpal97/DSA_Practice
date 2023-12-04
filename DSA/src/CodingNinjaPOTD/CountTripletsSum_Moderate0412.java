package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

// https://www.codingninjas.com/studio/problems/985256

public class CountTripletsSum_Moderate0412 {
	public static int countTriplets(DoubleLinkedListNode head,int x){
		// Write your code here
		int count = 0;
		List<Integer> list = new ArrayList<>();
		while(head != null)
		{
			list.add(head.data);
			head = head.next;
		}
		int size = list.size();

		for(int i=0;i<size-2;i++)
		{
			int start = i+1;
			int end = size-1;

			while(start<end)
			{
				int sum = list.get(i)+list.get(start)+list.get(end);
				if(sum == x)
				{
					count++;
					start++;
					end--;
				}
				else if(sum>x) end--;
				else if(sum<x) start++;
			}
		}

		return count;
	}
}