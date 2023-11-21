package StriverSheet175AndLoveBabbar450;

// https://leetcode.com/problems/design-a-stack-with-increment-operation

public class StackUsingArray {
	static int[] arr;
	static int index;
	static int cap;
	public StackUsingArray(int maxSize) {
		arr = new int[maxSize];
		index = 0;
		cap = maxSize;
	}

	public void push(int x) {
		if(index>=cap) return;
		arr[index] = x;
		index++;
	}

	public int pop() {
		if(index == 0) return -1;
		int res = arr[index-1];
		index--;
		return res;
	}

	public void increment(int k, int val) {
		if(k<index)
		{
			for(int i=0;i<k;i++)
			{
				arr[i] = arr[i]+val;
			}
		}
		else
		{
			for(int i=0;i<index;i++)
			{
				arr[i] = arr[i]+val;
			}
		}
	}
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */