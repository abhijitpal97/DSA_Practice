package com.example.amazonpractice;

public class MaxHighLowSizedArray {

	public static void main(String[] args)
	{
		int res = maxTurbulenceSize(new int[] {0,8,45,88,48,68,28,55,17,24});
		System.out.println(res);
	}

	public static int maxTurbulenceSize(int[] arr) {
		return Math.max(startWithMax(arr) , startWithMin(arr));
	}

	static int startWithMax(int[] arr)
	{
		boolean flag = false;
		if(arr.length == 1) return 1;
		int max = 0;
		int count = 1;
		for(int i=1;i<arr.length;i++)
		{
			if(!flag && arr[i]<arr[i-1])
			{
				flag = true;
				count++;
			}

			else if(flag && arr[i]>arr[i-1])
			{
				flag = false;
				count++;
			}
			else 
			{
				max = Math.max(max , count);
				if(count != 1) i--;
				count = 1;
				flag = false;
			}

			if(i == arr.length-1) max = Math.max(max , count);
		}

		return max;
	}

	static int startWithMin(int[] arr)
	{
		boolean flag = false;
		if(arr.length == 1) return 1;
		int max = 0;
		int count = 1;
		for(int i=1;i<arr.length;i++)
		{
			if(!flag && arr[i]>arr[i-1])
			{
				flag = true;
				count++;
			}

			else if(flag && arr[i]<arr[i-1])
			{
				flag = false;
				count++;
			}
			else 
			{
				max = Math.max(max , count);
				if(count != 1) i--;
				count = 1;
				flag = false;
			}

			if(i == arr.length-1) max = Math.max(max , count);
		}

		return max;
	}
}