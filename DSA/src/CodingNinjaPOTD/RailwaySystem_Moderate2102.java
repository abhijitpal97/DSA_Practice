package CodingNinjaPOTD;
import java.util.* ;
import java.io.*;

// https://www.codingninjas.com/studio/problems/moderate_6581776

class Passenger
{
	String station;
	int startTime;

	Passenger(String station , int startTime)
	{
		this.station = station;
		this.startTime = startTime;
	}
} 
public class RailwaySystem_Moderate2102 {
	Map<Integer,Passenger> map;
	Map<String , int[]> timeList;
	RailwaySystem_Moderate2102(){
		// Declare the data structures here.        
		map = new HashMap<>();
		timeList = new HashMap<>();
	}

	void checkIn(int passID, String station, int time){
		// Write your code here.
		map.put(passID , new Passenger(station , time));
	}

	void checkOut(int passID, String station, int time){
		// Write your code here.
		if(! map.containsKey(passID)) return;
		Passenger pass = map.get(passID);
		String key = pass.station+"_"+station;
		int duration = time - pass.startTime;
		map.remove(passID);

		if(timeList.containsKey(key))
		{
			int[] curr = timeList.get(key);
			curr[0] += duration;
			curr[1]++;

			timeList.put(key , curr);
		}
		else timeList.put(key , new int[]{duration , 1});
	}

	double getAverage(String source, String dest){
		// Write your code here.
		String key = source+"_"+dest;
		if(! timeList.containsKey(key)) return -1;

		int[] curr = timeList.get(key);

		return (double) curr[0]/curr[1];
	}
}