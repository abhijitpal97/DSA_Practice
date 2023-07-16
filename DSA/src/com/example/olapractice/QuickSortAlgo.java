package com.example.olapractice;


public class QuickSortAlgo
{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		quickSort(new int[] {8,4,5,2,3,9,7} , 0 , 6);
		
	}
	
	
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low<high)
        {
            int pivot = partition(arr , low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1 , high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        while(i<j)
        {
            while(arr[i]<=pivot && i<high) i++;
            while(arr[j]>pivot) j--;
            
            if(i<j) swap(arr ,i,j);
            
        }
        swap(arr,low,j);
        
        return j;
    }
    
    public static void swap(int[] arr , int i , int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}