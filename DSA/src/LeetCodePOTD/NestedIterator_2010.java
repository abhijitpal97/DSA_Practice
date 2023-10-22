package LeetCodePOTD;

import java.util.*;

interface NestedInteger {

	public boolean isInteger();
	public Integer getInteger();
	public List<NestedInteger> getList();
}

public class NestedIterator_2010 implements Iterator<Integer> {

	List<Integer> flat;
	int index;

	public NestedIterator_2010(List<NestedInteger> nestedList) {
		flat = new ArrayList<>();
		index = 0;
		flat = flatten(nestedList);    
	}

	List<Integer> flatten(List<NestedInteger> nested)
	{
		List<Integer> result = new ArrayList<>();

		for(NestedInteger ni : nested)
		{
			if(ni.isInteger()) result.add(ni.getInteger());
			else result.addAll(flatten(ni.getList()));
		}

		return result;
	}

	@Override
	public Integer next() {
		return flat.get(index++);
	}

	@Override
	public boolean hasNext() {
		return index<flat.size();
	}
}