package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/missing-and-repeating-numbers_873366

public class MisingAndRepeatingNumbers {

	public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
		// Write your code here
		int[] res = new int[2];
		int currS = 0;
		int actualS = 0;
		Set<Integer> set = new HashSet<>();
		for(int i : arr)
		{
			if(! set.add(i)) res[1] = i;
			else currS += i;
		}

		for(int i=1 ; i<=n; i++) actualS +=i;
		res[0] = actualS-currS;

		return res;
	}
}