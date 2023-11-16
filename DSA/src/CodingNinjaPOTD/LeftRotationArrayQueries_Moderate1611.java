package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/985298

class RotatePair
{
	int pos;
	int val;

	RotatePair(int pos , int val)
	{
		this.pos = pos;
		this.val = val;
	}
}
public class LeftRotationArrayQueries_Moderate1611 {

	public static void main(String[] args)
	{
		List<ArrayList<Integer>> result = leftRotationsOfArray
				(new ArrayList<>(Arrays.asList(15, 16, 8, 13, 19 )), 
						new ArrayList<>(Arrays.asList(1,2,6)));

		System.out.println(result);
	}

	public static List<ArrayList<Integer>> leftRotationsOfArray(List<Integer> nums, 
			List<Integer> queries) {
		// Write your code here.
		List<ArrayList<Integer>> result = new ArrayList<>();
		int n = queries.size();
		int m = nums.size();
		for(int i=0;i<n;i++) result.add(new ArrayList<>());

		List<RotatePair> list = new ArrayList<>();
		for(int i=0;i<n;i++) list.add(new RotatePair(i , queries.get(i)%m));
		Collections.sort(list , (a,b) -> a.val-b.val);

		for(int i=0;i<n;i++)
		{
			RotatePair p = list.get(i);
			int rotate = p.val;
			int pos = p.pos;
			int prevPos = 0;
			if(i!=0) 
			{
				rotate = rotate-list.get(i-1).val;
				prevPos = list.get(i-1).pos;
			}
			ArrayList<Integer> rotatedArray = rotateArray(nums ,result , rotate , i , prevPos);
			result.set(pos,rotatedArray);
		}

		return result;

	}

	static ArrayList<Integer> rotateArray(List<Integer> nums , List<ArrayList<Integer>> result ,
			int rotate , int i , int prevPos)
	{
		ArrayList<Integer> list = new ArrayList<>();
		if(i== 0)
		{
			ArrayList<Integer> curr= new ArrayList<>(nums);
			for(int x = rotate; x<curr.size();x++) list.add(curr.get(x));        
			for(int x=0;x<rotate;x++) list.add(curr.get(x));
		}
		else 
		{
			ArrayList<Integer> curr = result.get(prevPos);
			for(int x = rotate; x<curr.size();x++) list.add(curr.get(x));        
			for(int x=0;x<rotate;x++) list.add(curr.get(x));
		}

		return list;
	}
}