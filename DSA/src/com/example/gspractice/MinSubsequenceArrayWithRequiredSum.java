package com.example.gspractice;
import java.util.ArrayList;
 
public class MinSubsequenceArrayWithRequiredSum 
{
	static int min = Integer.MAX_VALUE;
	public static ArrayList<Integer> minSubsequence(ArrayList<Integer> arr, int n, int x) 
	{
		// Write your code here
		min = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		function(arr,list,new ArrayList<>(),n,x,0);
		return list;

	}

	static void function(ArrayList<Integer> arr , ArrayList<Integer> list , 
			ArrayList<Integer> temp , int n , int x , int index)
	{
		if(x<0)
		{
			if(min>temp.size())
			{
				list.clear();
				min = temp.size();
				for(int li : temp) list.add(li);
			}
			return;
		}

		if(index>=n) return;

		temp.add(arr.get(index));
		function(arr,list,temp,n,x-arr.get(index),index+1);
		temp.remove(temp.size()-1);
		function(arr,list,temp,n,x,index+1);
	}
}
