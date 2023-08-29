package com.example.uncategorized;

public class SelectionSortImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {5,6,1,2,9,4,10,3};
		selectionSort(arr);

		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<arr.length;i++) sb.append(i).append(" ");
		System.out.println(sb);

	}

	private static void selectionSort(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0 ;i<arr.length;i++)
		{
			int sEle = arr[i];
			int index = 0;
			for(int j = i+1 ; j<arr.length; j++)
			{
				if(arr[j]<sEle)
				{
					sEle =arr[j];
					index = j;
				}
			}
			swap(arr , i , index);
		}

	}

	private static void swap(int[] arr, int i, int index) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i]=arr[index];
		arr[index] = temp;

	}

}
