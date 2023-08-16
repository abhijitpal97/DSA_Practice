package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class StatsFromSampel_Moderate1608 
{
	public static ArrayList<Double> sampleStats(ArrayList<Integer> count) 
    {
		// Write your code here.
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		int maxC= 0 ;
		int mode = 0;
		for(int i=0;i<count.size();i++)
		{
			if(count.get(i) > 0)
			{
				int nums = count.get(i);
				if(nums>maxC)
				{
					maxC = nums;
					mode = i;
				}
				for(int j=0;j<nums;j++) 
				{
					list.add(i);
					sum +=i;
				}
			}
		}

		ArrayList<Double> result = new ArrayList<>();
		if(list.size() == 0) return result;

		result.add((double)list.get(0));
		result.add((double)list.get(list.size()-1));
		result.add((double)sum / list.size());
		if(list.size()%2 == 1) result.add((double)list.get(list.size()/2));
		else result.add(((list.get(list.size()/2))+(list.get((list.size()/2) - 1)))/2.0);
		result.add((double)mode);
		return result;
	}
}
