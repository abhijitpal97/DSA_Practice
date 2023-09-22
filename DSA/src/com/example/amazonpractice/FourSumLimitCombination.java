package com.example.amazonpractice;

import java.util.*;

public class FourSumLimitCombination
{
	public static void main(String[] args) {
		int res = combinationSum5(new int[] {2,3,5}, new int[] {5}, 
				new int[] {10,2,3}, new int[] {2,1}, 11);
		System.out.println(res);
	}


	public static int combinationSum5(int[] a , int[] b , int[] c , int[] d , int limit)
	{
		//TimeComplexity -> n^2 + n^2 + nlogn +nlogn+n^2

		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();

		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				int sum = a[i]+b[j];
				if(sum<limit) l1.add(sum);
			}
		}

		for(int i=0;i<c.length;i++)
		{
			for(int j=0;j<d.length;j++)
			{
				int sum = c[i]+d[j];
				if(sum<limit) l2.add(sum);
			}
		}

		Collections.sort(l1);
		Collections.sort(l2);
		int count =0;
		for(int i=0; i<l1.size() ; i++)
		{
			for(int j=0 ; j<l2.size(); j++)
			{
				if(l1.get(i)+l2.get(j) <= limit) count++;
				else break;
			}
		}

		return count;
	}
}