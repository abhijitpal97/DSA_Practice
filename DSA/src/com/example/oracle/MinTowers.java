package com.example.oracle;
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/temp_1467101

public class MinTowers {
	public static int minTowers(ArrayList<Integer> arr, int n) {
		ArrayList<Integer> base = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			int z = arr.get(i);

			int low = 0;
			int high = base.size();
			while (low < high) {
				int mid = (low + high) / 2;

				if (base.get(mid) > z) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}
			if (low == base.size()) {

				// Create new tower.
				base.add(z);
			} else {

				// Add to min towers.
				base.set(low, z);
			}
		}

		return base.size();
	}
}