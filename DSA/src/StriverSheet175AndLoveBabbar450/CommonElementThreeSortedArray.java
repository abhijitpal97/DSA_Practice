package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/common-elements-in-three-sorted-arrays_1113130

public class CommonElementThreeSortedArray 
{
	public static void main(String[] args)
	{
		ArrayList<Integer> result = findCommonElements(
				new ArrayList<Integer>(Arrays.asList(4 , 4 , 5)),
				new ArrayList<Integer>(Arrays.asList(1 , 1 , 1 , 2)), 
				new ArrayList<Integer>(Arrays.asList(2 , 2 , 2 , 3)));

		System.out.println(result);
	}
	public static ArrayList<Integer> findCommonElements(ArrayList<Integer> a,
			ArrayList<Integer> b, ArrayList<Integer> c) 
	{
		// Write your code here.
		ArrayList<Integer> result = new ArrayList<>();

		ArrayList<Integer> temp = new ArrayList<>();
		int i=0;
		int j=0;
		while(i<a.size() && j<b.size())
		{
			if(a.get(i) == b.get(j)) 
			{
				temp.add(a.get(i));
				i++;
				j++;
			}
			else if(a.get(i)>b.get(j)) j++;
			else if(a.get(i)<b.get(j)) i++;
		}

		int k = 0;
		int l = 0;
		while(k<c.size() && l<temp.size())
		{
			if(temp.get(k) == c.get(l)) 
			{
				result.add(c.get(l));
				k++;
				l++;
			}
			else if(temp.get(k)>c.get(l)) l++;
			else if(temp.get(k)<c.get(l)) k++;
		}

		return result;
	}
}