package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/collect-balls_3155164?leftPanelTab=0
public class CollectBalls_Moderate2907 {

	public static int collectBalls(int N) {

		// Write your Code here
		int result = 0;

		for(int i = 2 ; i<= (int)Math.sqrt(N); i++)
		{
			while(N%i == 0)
			{
				N /= i;
				result += i;
			}

		}
		if(N>1)
		{
			result +=N;
		}
		return result;
	}
}
