package CodingNinjaPOTD;

public class SumAllGreaterLeft_Hard2708 {
	public static int[] fenwikTree(int[] arr, int N) {
		// Write your code here
		int[] res = new int[N];
		res[0] = 0;
		for(int i=1;i<N;i++)
		{
			int sum = 0;
			for(int j=0 ; j<i ; j++)
			{
				if(arr[j]>arr[i]) sum += arr[j];
			}
			res[i] = sum;
		}
		
		return res;
	}

}
