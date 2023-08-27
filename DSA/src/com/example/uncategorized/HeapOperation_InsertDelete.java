package com.example.uncategorized;

public class HeapOperation_InsertDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 1000;
		int[] arr = new int[MAX];

		// initializing some values
		arr[0] = 10;
		arr[1] = 5;
		arr[2] = 3;
		arr[3] = 2;
		arr[4] = 4;

		int n = insert(arr , 5 , 15);
		print(arr , n);
		n = insert(arr , n , 7);
		print(arr , n);
		n = insert(arr , n , 9);
		print(arr , n);
		n = insert(arr , n , 21);
		print(arr , n);
		n = delete(arr, n+1);
		print(arr, n);
		
		buildHeap(arr, n);
		print(arr, n);

	}

	private static void print(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n ;i++)
		{
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}

	static int insert(int[] A , int n , int key)
	{
		A[n] = key;

		int i = n;

		while(i>0)
		{
			int parent = (i-1)/2;
			if(A[parent] < A[i]) 
			{
				int temp = A[parent];
				A[parent] = A[i];
				A[i] = temp;
				i = parent;			
			}
			else return n+1;
		}
		return n+1;
	}

	static int delete(int[] A , int n)
	{
		A[0] = A[n-1];
		n = n-1;
		int i = 0;
		while(i<n)
		{
			int left = A[2*i + 1];
			int right = A[2*i + 2];
			int larger = left>right ? 2*i +1 : 2*i +2;
			if(A[i] < A[larger])
			{
				int temp = A[i];
				A[i] = A[larger];
				A[larger] = temp;
				i = larger;
			}
			else return n-1;
		}
		return n-1;
	}

	static void heapify(int[] A , int n , int i)
	{
		int largest = i;
		int left =  2*i+1;
		int right = 2*i+2;

		if(left<=n && A[left]>A[largest]) largest = left;
		if(right<=n && A[right]>A[largest]) largest = right;

		if(largest == i) return;
		int temp = A[largest];
		A[largest] = A[i];
		A[i] = temp;
		heapify(A, n, largest);
	}

	static void buildHeap(int[] A , int n)
	{
		for(int i=n-1;i>=0;i--)
		{
			heapify(A, n, i);
		}
	}
}
