package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/non-decreasing-array_699920

public class NonDecresingArrayIsPossible_Moderate2301 {

	public static boolean isPossible(int[] arr, int n) {

		int index = -1;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {

				if (index != -1) {
					return false;
				}

				index = i;
			}
		}

		if (index == -1 || index == 0 || index == n - 2) {
			return true;
		}

		if (arr[index - 1] <= arr[index + 1]) {
			return true;
		}

		if (arr[index] <= arr[index + 2]) {
			return true;
		}

		return false;
	}

}