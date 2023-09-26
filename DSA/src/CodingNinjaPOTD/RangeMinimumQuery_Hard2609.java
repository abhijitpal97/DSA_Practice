package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/range-minimum-query_2698980

public class RangeMinimumQuery_Hard2609 {
	public static int[] rangeMinimumQuery(int s, int[] arr, int q, int[][] query) {
		// Array to store the minimum element for each query.
		int[] ans = new int[q];

		// Process queries.
		for (int i = 0; i < q; i++) {

			// Initialize 'minElement' to store the answer for the current query.
			int minElement = Integer.MAX_VALUE;

			// Iterate from 'L' to 'R' indices of 'ARR'.
			for (int j = query[i][0]; j <= query[i][1]; j++) {
				minElement = Math.min(minElement, arr[j]);
			}

			// Insert the answer calculated into 'ans'.
			ans[i] = minElement;
		}

		// Finaly, return 'ans'.
		return ans;
	}
}