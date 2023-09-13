package com.example.amazonpractice;

public class LongestMountain {
	public static void main(String[] args)
	{
		int longest = longestMountain(new int[] {0,1,2,3,4,5,4,3,2,1,0});
		System.out.println(longest);
	}
	public static int longestMountain(int[] arr) {
		int max = 0;

		for(int i =0; i<arr.length;i++)
		{
			int left = 0;
			int right = 0;
			int currL = arr[i];
			int currR = arr[i];
			for(int j = i-1; j>=0 ; j--)
			{
				if(arr[j]<currL)
				{
					left++;
					currL = arr[j];
				}
				else break;
			}

			for(int j = i+1; j<arr.length ; j++)
			{
				if(arr[j]<currR)
				{
					right++;
					currR = arr[j];
				}
				else break;
			}

			if(left == 0) continue;
			if(right == 0) continue;
			int res = left+right+1;
			if(res>=3) max = Math.max(res , max);
		}

		return max;
	}
}