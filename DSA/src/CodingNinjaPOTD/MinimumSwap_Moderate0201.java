package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/minimum-swapping_2279810

public class MinimumSwap_Moderate0201 {

	// 	O(n^2)
	public static int minimumSwap(int[] arr, int n) {
		// Write your code here
		int[] cloneArr = new int[n];
		for(int i=0;i<n;i++) cloneArr[i] = arr[i];

		int r = 0;
		int l = 0;

		int c1 = 0;
		for(int i=r;i<n;i++)
		{
			if(cloneArr[i] == 0) continue;

			for(int j =i-1;j>=0; j--)
			{
				if(cloneArr[j] == 0) c1++;
				else break;
			}

			swap(cloneArr , l , i);
			l++;
		}

		r = n-1;
		l = n-1;

		int c2 = 0;
		for(int i=r;i>=0;i--)
		{
			if(arr[i] == 0) continue;

			for(int j =i+1;j<n; j++)
			{
				if(arr[j] == 0) c2++;
				else break;
			}

			swap(arr , l , i);
			l--;
		}

		return Math.min(c1,c2);

	}

	static void swap(int[] arr , int i , int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
