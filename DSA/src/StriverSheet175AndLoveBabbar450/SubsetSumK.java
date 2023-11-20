package StriverSheet175AndLoveBabbar450;
import java.util.*;

// https://www.codingninjas.com/studio/problems/return-subsets-sum-to-k_759331

public class SubsetSumK {
	public static void findSubsetsThatSumToKHelper(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, 
    ArrayList<Integer> curSubset, int k, int idx , int n) {

		if (idx == n) {
			if (k == 0) {
				if(! ans.contains(curSubset))ans.add(curSubset);
			}
			return;
		}
		// Case when we include the current element in the subset.
		findSubsetsThatSumToKHelper(arr, ans, curSubset, k, idx + 1 , n);
		
		// Case when we include the current element in the subset.
		ArrayList<Integer> curSubset1 = new ArrayList<>(curSubset);
                curSubset1.add(arr.get(idx));

		findSubsetsThatSumToKHelper(arr, ans, curSubset1, k - arr.get(idx), idx + 1 , n);
	
	}

	public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		findSubsetsThatSumToKHelper(arr, ans, new ArrayList<>(), k, 0 , n);

		return ans;
	}
}