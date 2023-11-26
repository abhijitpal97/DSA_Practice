package CodingNinjaPOTD;

import java.util.*;

import com.example.datastructure.skeleton.DoubleLinkedListNode;

// https://www.codingninjas.com/studio/problems/queries-on-stack_1496513

public class AnswerQueries_Moderate2611 {
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>(Arrays.asList(1,3)));
		result.add(new ArrayList<>(Arrays.asList(1,2)));
		result.add(new ArrayList<>(Arrays.asList(1,1)));
		result.add(new ArrayList<>(Arrays.asList(3,2,1)));
		result.add(new ArrayList<>(Arrays.asList(1,1)));
		result.add(new ArrayList<>(Arrays.asList(2)));
		result.add(new ArrayList<>(Arrays.asList(3,3,3)));
		result.add(new ArrayList<>(Arrays.asList(2)));
		result.add(new ArrayList<>(Arrays.asList(2)));
		result.add(new ArrayList<>(Arrays.asList(2)));

		ArrayList<Integer> sol = answerQueries(
				result, 3);
		System.out.println(sol);
	}
	public static ArrayList<Integer> answerQueries(ArrayList<ArrayList<Integer>> queries, int limit) {
		// Write your code here.
		List<Integer> list = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(ArrayList<Integer> que : queries)
		{
			int type = que.get(0);
			int size = list.size();

			if(type==1 && size==limit) continue;
			else if(type==1 && size<limit)
			{
				list.add(que.get(1));
			}
			else if(type == 2)
			{
				if(size==0) result.add(-1);
				else 
				{
					result.add(list.get(size-1));
					list.remove(size-1);					
				}
			}
			else if(type == 3)
			{
				int k = que.get(1);
				int l = que.get(2);
				for(int i=0;i<Math.min(k,size);i++)
				{
					list.set(i,list.get(i)+l);
				}

			}
		}

		return result;
	}
}