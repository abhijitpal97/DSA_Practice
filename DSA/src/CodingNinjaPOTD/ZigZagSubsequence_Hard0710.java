package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/zig-zag-subsequence_1473863

public class ZigZagSubsequence_Hard0710 
{
	public static void main(String[] args)
	{
		int res = zigZagSubsequence(new int[] {1 ,9 ,8, 10, 2, 4, 0, 5, 1});
		System.out.println(res);
	}

	public static int zigZagSubsequence(int[] tokenArray) 
	{
		// Write your code here
		int n = tokenArray.length;
		int[] inc = new int[n];
		int[] dec = new int[n];        
		int longest = 1;
		for(int i=0;i<n ;i++)
		{
			inc[i] = 1;
			dec[i] = 1;

			for(int j =0;j<i;j++)
			{
				if(tokenArray[i]>tokenArray[j]) inc[i] = Math.max(inc[i] , dec[j]+1);
				if(tokenArray[i]<tokenArray[j]) dec[i] = Math.max(dec[i] , inc[j]+1);
			}
		}

		for(int i=0;i<n;i++)
		{
			longest = Math.max(longest , Math.max(inc[i] , dec[i]));
		}

		return longest;
	}   


}