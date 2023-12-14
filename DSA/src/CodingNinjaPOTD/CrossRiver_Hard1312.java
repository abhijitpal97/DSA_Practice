package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/help-ninja-to-cross-river_1235196

public class CrossRiver_Hard1312 {

	public static void main(String[] args)
	{
		boolean res = crossRiver(new ArrayList<>(Arrays.asList(0,1,3,5,7)));
		System.out.println(res);
	}
	public static boolean crossRiver(ArrayList<Integer> safe) {
		// Write your code here.
		int n = safe.size();
		Map<Integer,Integer> map = new HashMap<>();
		Boolean[][] dp = new Boolean[n][n+1];

		for(int i =0; i<safe.size() ; i++) map.put(safe.get(i) , i);

		if(safe.get(1) - safe.get(0) == 1) return solve(safe , 1 ,1 , map , dp); 

		return false;
	}

	static boolean solve(ArrayList<Integer> safe , int index , int x , 
			Map<Integer,Integer> map , Boolean[][] dp)
	{
		if(index == safe.size()-1) return true;
		if(dp[index][x] != null) return dp[index][x];

		int p1 = safe.get(index)+x;
		int p2 = safe.get(index)+x+1;
		int p3 = safe.get(index)+x-1;

		if(map.containsKey(p1))
		{
			if(solve(safe , map.get(p1) , x , map , dp)) return true;
		}

		if(map.containsKey(p2))
		{
			if(solve(safe , map.get(p2) , x+1 , map , dp)) return true;
		}

		if(x-1>0 && map.containsKey(p3))
		{
			if(solve(safe , map.get(p3) , x-1 , map , dp)) return true;
		}

		return dp[index][x] = false;
	}
}