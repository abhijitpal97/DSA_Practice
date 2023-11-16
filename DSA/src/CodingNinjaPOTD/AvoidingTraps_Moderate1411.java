package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
// https://www.codingninjas.com/studio/problems/avoiding-traps_839704

public class AvoidingTraps_Moderate1411 {
	public static int avoidTraps(ArrayList<Integer> obstacles, int n) {
		// Write your code here.
		int lastEle = 0;
		for(int i : obstacles) lastEle = Math.max(lastEle , i);
		lastEle++;

		for(int i = 1 ; i<=lastEle ; i++)
		{
			if(isPossible(i,i,obstacles,lastEle)) return i;
		}

		return -1;
	}

	static boolean isPossible(int curr , int jump, ArrayList<Integer> obstacles , int target)
	{
		while(curr<target)
		{
			if(obstacles.contains(curr)) return false;
			curr +=jump;
		}
		if(curr>=target) return true;
		return false;
	}
}