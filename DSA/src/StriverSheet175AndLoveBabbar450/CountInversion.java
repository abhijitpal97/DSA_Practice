package StriverSheet175AndLoveBabbar450;

// https://www.codingninjas.com/studio/problems/count-inversions_615

public class CountInversion {
	public static long getInversions(long arr[], int n) {
		// Write your code here.
		return mergeSort(arr , 0 , n-1);
	}

	static long mergeSort(long[] arr , int left , int right)
	{
		long count =0;
		if(right>left)
		{
			int mid = (right+left)/2;

			count = mergeSort(arr,left,mid);
			count += mergeSort(arr,mid+1,right);

			count += merge(arr,left,mid+1,right);
		}

		return count;
	}

	static long merge(long[] arr, int left , int mid , int right)
	{
		int i = left;
		int j = mid;
		int k = 0;
		long count =0;
		long[] temp = new long[right-left+1];

		while((i<mid) && (j<=right))
		{
			if(arr[i]<=arr[j])
			{
				temp[k] = arr[i];
				k++;
				i++;
			}
			else
			{
				temp[k] = arr[j];
				count += mid-i;
				k++;
				j++;
			}
		}

		while(i<mid)
		{
			temp[k]= arr[i];
			k++;
			i++;
		}

		while(j<=right)
		{
			temp[k] = arr[j];
			k++;
			j++;
		}

		for(i=left, k=0 ; i<=right;i++,k++)
		{
			arr[i] = temp[k];
		}

		return count;

	}
}