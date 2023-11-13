package StriverSheet175AndLoveBabbar450;
import java.io.*;
import java.util.* ;

// https://www.codingninjas.com/studio/problems/ninja-and-sorted-arrays_1214628

public class MergeTwoSortedArrays {
	public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
		// Write your code here.
		int[] res = new int[n+m];
		int i = 0;
		int j = 0;
		int k = 0;

		while(i<m && j<n)
		{
			if(arr1[i]<arr2[j])
			{
				res[k] = arr1[i];
				i++;
				k++;
			}
			else
			{
				res[k] = arr2[j];
				j++;
				k++;
			}
		}
		while(i<m)
		{
			res[k] = arr1[i];
			i++;
			k++;
		}

		while(j<n)
		{
			res[k] = arr2[j];
			j++;
			k++;
		}

		return res;
	}
}
