package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/ninja-and-the-list_3839607

// Dummy Class Impl
class NestedInteger {

	public boolean isInteger() {
		// TODO Auto-generated method stub
		return false;
	}

	public Integer getInteger() {
		// TODO Auto-generated method stub
		return null;
	}

	public NestedInteger[] getList() {
		// TODO Auto-generated method stub
		return null;
	}

}

public class NestedIterator_Moderate2711{

	ArrayList<Integer> answer = new ArrayList<Integer>();
	int i = 0;
	NestedIterator_Moderate2711(List<NestedInteger> nestedList) {
		for (NestedInteger x : nestedList) {
			makeFlat(x);
		}
	}
	public int next() {
		int to_ret = answer.get(i);
		i++;
		return to_ret;
	}
	public boolean hasNext() {
		return i < answer.size();
	}

	void makeFlat(NestedInteger x) {
		if (x.isInteger()) {
			answer.add(x.getInteger());
		} else {
			for (NestedInteger y : x.getList()) {
				makeFlat(y);
			}
		}
	}
};