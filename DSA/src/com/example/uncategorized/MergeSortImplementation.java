package com.example.uncategorized;

public class MergeSortImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {5,6,1,2,9,4,10,3};
		mergeSort(arr , 0 , arr.length-1);

		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<arr.length;i++) sb.append(i).append(" ");
		System.out.println(sb);

	}

	private static void mergeSort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end) return;

		int mid = start +(end - start)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		sort(arr , start , mid , end);

	}

	private static void sort(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int n1 = mid-start+1;
		int n2 = end-mid;
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		for(int i=0;i<n1;i++) arr1[i] = arr[start+i];
		for(int i=0;i<n2;i++) arr2[i] = arr[mid+1+i];

		int i = 0;
		int j = 0;
		int k = start;

		while(i<n1 && j <n2)
		{
			if(arr1[i] <= arr2[j])
			{
				arr[k] = arr1[i];
				i++;
			}
			else
			{
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}

		while(i<n1)
		{
			arr[k] = arr1[i];
			i++;
			k++;
		}

		while(j <n2)
		{
			arr[k] = arr2[j];
			j++;
			k++;
		}


	}

}
