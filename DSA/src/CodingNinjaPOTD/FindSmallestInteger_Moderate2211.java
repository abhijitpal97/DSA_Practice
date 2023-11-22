package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/moderate_6581722

public class FindSmallestInteger_Moderate2211 {
	public static int findSmallestInteger(int[] arr) {
		// Write your code here
		if(arr.length == 0) return 1;
		List<Integer> list = new ArrayList<>();
		generateAllSum(arr, 0 , arr.length , list , 0);
		Collections.sort(list);
		//System.out.println(list);
		int smallest = 1;
		for(int i=1;i<list.size();i++)
		{
			if(list.get(i) == smallest) smallest++;
			else return smallest;
		}
		return smallest;
	}

	static void generateAllSum(int[] arr , int index , int n , List<Integer> list , int curr)
	{
		if(index >=n)
		{
			if(! list.contains(curr)) list.add(curr);
			return;
		}

		generateAllSum(arr , index+1 , n , list , curr+arr[index]);
		generateAllSum(arr , index+1 , n , list , curr);
	}
}