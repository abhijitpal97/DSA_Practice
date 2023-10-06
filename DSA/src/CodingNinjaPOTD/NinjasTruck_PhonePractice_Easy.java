package CodingNinjaPOTD;
import java.util.*;

// https://www.codingninjas.com/studio/problems/ninja-s-truck_1459118

public class NinjasTruck_PhonePractice_Easy 
{
	public static int ninjaTruck(ArrayList<ArrayList<Integer>> box, int k)
	{
		// Write your code here
		Collections.sort(box , (a,b) -> b.get(1) - a.get(1));

		int max = 0;

		for(int i=0;i<box.size();i++)
		{
			ArrayList<Integer> curr = box.get(i);
			int b = curr.get(0);
			int m = curr.get(1);

			if(b<=k)
			{
				max +=b*m;
				k -= b;
			}
			else
			{
				max += k * m;
				k =0;
			}
		}

		return max;
	}
}

