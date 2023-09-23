package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/chocolate-and-sweetness_2542078
public class ChocholateSweetness_Hard1808 {
	public static int[] chocolatesAndSweetness(int n, int q, int[] expiry, int[] sweetness, int[][] query) {
		// Write your code here
		int[] res = new int[q];
		int index = 0;
		for(int[] qu : query)
		{
			int sweetP = qu[0];
			int expireP = qu[1];
			int count = 0;
			for(int i=0;i<n;i++)
			{
				if(sweetness[i]>=sweetP && expiry[i]>expireP) count++;
			}
			res[index] = count;
			index++;
		}

		return res;
	}

}
