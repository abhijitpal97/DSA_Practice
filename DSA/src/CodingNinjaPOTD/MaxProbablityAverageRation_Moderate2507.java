package CodingNinjaPOTD;


import java.util.ArrayList;

public class MaxProbablityAverageRation_Moderate2507 {
	static double probablities = Double.MIN_VALUE;
	public static double maxAverageWorkingRatio(ArrayList<ArrayList<Integer>> bulbs, int n, int extra) {
		// Write your code here
		probablities = Double.MIN_VALUE;
		function(bulbs , extra);
		return probablities;
	}

	static void function(ArrayList<ArrayList<Integer>> bulbs , int extra)
	{
		
		if(extra == 0)
		{
			double prob = 0;
			
			for(ArrayList<Integer> bulb : bulbs)
			{
				int working = bulb.get(0);
				int total  = bulb.get(1);

				prob += (double)working/total;
			}
			//System.out.println(prob+ " --->"+probablities);
			probablities = Math.max(probablities , prob/bulbs.size());
			return;
		}

		for(ArrayList<Integer> bulb : bulbs)
		{
				int temp = bulb.get(0);
				int total = bulb.get(1);
				bulb.set(0 , temp+1);
				bulb.set(1 , total+1);
				function(bulbs , extra-1);
				bulb.set(0 , temp);
				bulb.set(1 , total);
			}
		
	}
}