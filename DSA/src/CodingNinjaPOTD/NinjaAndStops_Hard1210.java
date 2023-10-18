package CodingNinjaPOTD;
import java.util.*;

// https://www.codingninjas.com/studio/problems/ninja-and-stops_1262353?leftPanelTab=0

public class NinjaAndStops_Hard1210 {
	static int min = Integer.MAX_VALUE;

	// Recursion

	public static int minRefuelStops(int target, int startFuel, ArrayList<ArrayList<Integer>> stations) {
		// Write your code here.
		int min = minRefile(startFuel , 0 , target , 0 , stations.size() , stations);
		return min>=Integer.MAX_VALUE-1?-1:min;
	}

	static int minRefile(int fuel , int dist , int target , int index , int  n ,
			ArrayList<ArrayList<Integer>> stations)
	{
		if(fuel >= (target-dist))  return 0;
		if(dist == target) return 0;
		if(dist != target && index == n) return Integer.MAX_VALUE-1;
		if(fuel < stations.get(index).get(0) - dist) return Integer.MAX_VALUE-1; 

		int pick = 1+minRefile(fuel-stations.get(index).get(0)+dist+stations.get(index).get(1) , 
				stations.get(index).get(0) , target, index+1,n,stations);
		int notPick = minRefile(fuel-stations.get(index).get(0)+dist, 
				stations.get(index).get(0) , target, index+1,n,stations);

		return Math.min(pick , notPick);

	}
}