package com.example.amazonpractice;

import java.util.*;

// https://leetcode.com/problems/sum-of-subarray-minimums/description/

public class SumOfSubArrayMinimum {
	public int sumSubarrayMins(int[] arr) {
		int sum = 0 ;

		for(int i=0;i<arr.length;i++)
		{
			List<Integer> list = new ArrayList<>();
			for(int j=i;j<arr.length;j++)
			{
				list.add(arr[j]);
				sum = (sum + getMin(list))%1000000007;
			}
		}

		return sum%1000000007;
	}

	public int getMin(List<Integer> list)
	{
		if(list.size()==1) return list.get(0);
		Collections.sort(list);
		return list.get(0);
	}


	// Time Complexity - O(n) - With Extra space - O(n)

	public int sumSubarrayMinsTimeComplexityFix(int[] arr) {
		int len= arr.length;
		int MOD = 1000000007;
		int [] left= new int [len];
		int [] right =new int [len];
		Stack<Integer> st= new Stack<>();
		for(int i=0;i<len;i++){
			if(st.isEmpty()){
				left[i]=-1;
			}
			else if(arr[st.peek()]<arr[i]){
				left[i]=st.peek();
			}
			else{
				while(!st.isEmpty()&& arr[st.peek()]>=arr[i]){
					st.pop();
				}
				if(st.isEmpty()){
					left[i]=-1;
				}else{
					left[i]=st.peek();
				}
			}
			st.push(i);
		}

		st.clear();

		for(int i=len-1; i>=0;i--)
		{
			if(st.isEmpty())
			{
				right[i]=len;
			}
			else if(arr[st.peek()]<arr[i])
			{
				right[i]=st.peek();
			}
			else
			{
				while(! st.isEmpty() && arr[st.peek()]>arr[i])
				{
					st.pop();
				}

				if(st.isEmpty()) right[i]=len;
				else right[i]=st.peek();
			}

			st.push(i);
		}

		long res = 0;
		for(int i=0;i<len;i++)
		{
			long lR = (long)i - left[i];
			long rR = right[i]-(long)i;

			res = (res + (arr[i]*lR%MOD*rR%MOD))%MOD;
		}

		return (int)res;
	}
}