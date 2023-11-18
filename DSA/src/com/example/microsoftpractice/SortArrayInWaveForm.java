package com.example.microsoftpractice;
import java.util.*;

// https://www.codingninjas.com/studio/problems/sort-an-array-in-wave-form_975285

public class SortArrayInWaveForm {

	public static int[] waveFormArray(int[] arr, int n) {
		// Write your code here.
		// 1 2 2 3 3 4 5
		//5 2 4 2 3 1 3
		int[] res = new int[n];
		Arrays.sort(arr);

		int end = n-1;
		int index = 0;

		while(index<n)
		{
			res[index] = arr[end];
			end--;
			index +=2;
		}
		index = 1;
		while(index<n)
		{
			res[index] = arr[end];
			end--;
			index +=2;
		}

		return res;
	}

}
