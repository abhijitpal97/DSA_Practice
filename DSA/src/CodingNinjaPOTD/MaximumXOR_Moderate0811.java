package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/maximum-xor_3119012

public class MaximumXOR_Moderate0811 {
	public static int maximumXor(int []A) {
		// Write your code here.
		int max = Integer.MIN_VALUE;

		for(int i=0;i<A.length-1;i++)
		{
			for(int j=i+1;j<A.length;j++)
			{
				int local = A[i]^A[j];
				max = Math.max(max , local);
			}
		}

		return max==Integer.MIN_VALUE?0:max;
	}
}
