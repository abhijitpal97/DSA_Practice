package CodingNinjaPOTD;

import java.util.*;

class PairSort {
	int first;
	int second;

	PairSort(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class MaxIndexDiff_Hard_1308 {

	public static void main(String[] args)
	{
		int res = maxIndexDiffSorting(new int[]{5,3,1,7,4,3,9}, 7);
		System.out.println(res);
	}
	public static int maxIndexDiff(int[] arr, int n) {
		// Write your code here
		int min = -1;
		for(int i = 0;i<n;i++)
		{
			for(int j=i+1 ; j<n;j++)
			{
				if(arr[j]>arr[i]) min = Math.max(min , j-i);
			}
		}

		return min;
	}


	public static int maxIndexDiffSorting(int[] arr, int n) {

		// saving the indices along with the values.
		ArrayList<PairSort> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(new PairSort(arr[i], i));
		}

		// sorting the list.
		Collections.sort(list, new Comparator<PairSort>() {
			@Override
			public int compare(PairSort p1, PairSort p2) {
				return p1.first - p2.first;
			}
		});

		// maintaining the suffix array, for the largest index.
		int suffix[] = new int[n];
		int currMax = Integer.MIN_VALUE, ans = 0;

		// inserting maximum value of index in our suffix array.
		for (int i = n - 1; i >= 0; i--) {
			currMax = Math.max(currMax, list.get(i).second);
			suffix[i] = currMax;
		}

		// updating our final answer.
		for (int i = 0; i < n - 1; i++) {
			ans = Math.max(ans, suffix[i + 1] - list.get(i).second);
		}

		// returning our final updated answer.
		if (ans == 0) {
			return -1;
		}

		return ans;
	}
}
