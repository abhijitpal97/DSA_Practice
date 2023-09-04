package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class FrequencyStack_Hard0409
{
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	Map<Integer,Integer> map;
	FrequencyStack_Hard0409()
	{
		// Complete the function
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		map = new HashMap<>();

	}

	void push(int element)
	{
		// Complete the function
		stack1.push(element);
		map.put(element , map.getOrDefault(element , 0)+1);

	}
	int pop()
	{
		// Complete the function
		if(stack1.isEmpty()) return -1;
		int del = getMaxMap();
		while(stack1.peek() != del)
		{
			stack2.push(stack1.pop());
		}
		stack1.pop();
		map.put(del,map.get(del)-1);
		if(map.get(del) == 0) map.remove(del);

		while(! stack2.isEmpty()) stack1.push(stack2.pop());

		return del;

	}

	int getMaxMap()
	{
		List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());

		Collections.sort(list , new Comparator<Map.Entry<Integer,Integer>>()
		{
			public int compare(Map.Entry<Integer,Integer> o1 , Map.Entry<Integer,Integer> o2)
			{
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		return list.get(0).getValue();
	}
}