package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/kevin-and-his-fruits_1164267

public class FruitProblems 
{
	public static int getMaxMarker(ArrayList<Integer> arr, int n, int m) 
	{
		int max = 0;
		for(int i : arr) max = Math.max(max , i);

		int left = 0;
		int right = max;

		while(left<right)
		{
			int mid = (left+right+1)/2;

			int count = 0;

			for(int i=0;i<n;i++)
			{
				if(arr.get(i) - mid >0) count += arr.get(i)-mid;
			}

			if(m == count) return mid;
			else if(count<m) right = mid-1;
			else left = mid;
		}

		return left;
	}
}