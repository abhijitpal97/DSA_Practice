package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 


public class SquareFulArrays_Hard0508 {
	static int count=0;

	public static void main(String[] args)
	{
		numberOfSquarefulArrays(new int[] {4,0,4,0,4}, 5);
		System.out.println(count);
	}

	public static int numberOfSquarefulArrays(int[] arr, int n) {
		// Write your code here.
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : arr) map.put(i , map.getOrDefault(i , 0)+1);
		List<List<Integer>> result = new ArrayList<>();
		getPermutation(map , arr , n , result ,new ArrayList<Integer>() , 0);
		return count;
	}

	static void getPermutation(Map<Integer,Integer> map , int[] arr , int n,  List<List<Integer>>  result , List<Integer> curr , int index)
	{
		if(index==n)
		{
			if(!result.contains(curr) && isSquareArray(curr)) 
			{
				result.add(new ArrayList<>(curr));
				count++;
			}
			return;
		}

		for(int i=0;i<n;i++)
		{
			if(map.get(arr[i]) == 0) continue;
			map.put(arr[i] , map.get(arr[i])-1);
			curr.add(arr[i]);
			getPermutation(map , arr,n,result,curr,index+1);
			curr.remove(curr.size()-1);
			map.put(arr[i] , map.get(arr[i])+1);
		}
	}

	static boolean isSquareArray(List<Integer> curr)
	{
		long sum = curr.get(0);
		for(int i = 1;i<curr.size();i++)
		{
			sum +=curr.get(i);
			double sqrt = Math.sqrt(sum);
			long back = (long)(sqrt+0.5);
			if(back*back != sum) return false;

			sum -=curr.get(i-1);
		}

		return true;
	}
}
