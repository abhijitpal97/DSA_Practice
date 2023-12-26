package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/maxfrequencystack_1262006

public class FrequencyStack_Hard2512
{
	Map<Integer,Integer> map;
	Map<Integer , Stack<Integer>> stackMap;
	int max;
	FrequencyStack_Hard2512()
	{
		// Complete the function
		map = new HashMap<>();
		stackMap = new HashMap<>();
		max = 0;

	}

	void push(int element)
	{
		// Complete the function
		map.put(element , map.getOrDefault(element , 0)+1);

		max = Math.max(max , map.get(element));

		int freq = map.get(element);

		if(! stackMap.containsKey(freq))
		{
			stackMap.put(freq , new Stack<>());
		}
		stackMap.get(freq).push(element);
	}
	int pop()
	{
		// Complete the function
		if(max == 0) return -1;

		int x = stackMap.get(max).pop();

		map.put(x , map.get(x)-1);

		if(stackMap.get(max).isEmpty()) max--;

		return x;

	}

}