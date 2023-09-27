package com.example.amazonpractice;

// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class MaxPageBookAllocation 
{
	//Function to find minimum number of pages.
	public static int findPages(int[]A,int N,int M)
	{
		//Your code here
		if(N<M) return -1;

		int low = maxBookPage(A);
		int high = allBookPage(A);
		int res = -1;
		while(low<=high)
		{
			int mid = (high+low)/2 ;
			if(allocationPossible(A , mid , M))
			{
				res = mid;
				high = mid -1;
			}

			else low = mid+1;
		}

		return res;
	}

	static boolean allocationPossible(int[] A , int range , int students)
	{
		int allocatedStudents = 1;
		int curr = 0;
		for(int i=0;i<A.length;i++)
		{
			if(curr+A[i] > range)
			{
				allocatedStudents++;
				curr = 0;
				curr += A[i];
			}
			else curr +=A[i];
		}

		return allocatedStudents<=students;
	}

	static int maxBookPage(int[] A)
	{
		int res = 0;
		for(int  i : A) res = Math.max(res , i);
		return res;
	}

	static int allBookPage(int[] A)
	{
		int res = 0;
		for(int  i : A) res += i;
		return res;
	}
};