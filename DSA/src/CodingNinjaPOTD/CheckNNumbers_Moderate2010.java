package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class CheckNNumbers_Moderate2010 {

	public static void main(String[] args)
	{
		int num = getNewNum(new ArrayList<>(Arrays.asList(6,7,8,9)), 4);
		System.out.println(num);
	}

	public static int getNewNum(ArrayList<Integer> arr, int n) {

		// Write your code here.
		List<String> list = new ArrayList<>();
		int maxL = 0;
		for(int ar : arr)
		{
			String str = String.valueOf(Integer.toBinaryString(ar));
			maxL = Math.max(maxL , str.length());
			list.add(str);
		} 

		for(int i=0; i<list.size() ; i++)
		{
			String str = list.get(i);
			int diff = maxL-str.length();

			String x="";
			for(int j=0; j<diff ; j++)
			{
				x +="0";
			}

			x += str;

			list.set(i , x);
		}

		String s1 = "";
		for(int i=0; i<maxL ; i++)
		{
			int zero = 0;
			int one = 0;

			for(String str : list)
			{
				char ch = str.charAt(i);
				if(ch == '0') zero++;
				if(ch == '1') one++;
			}

			if(zero>=one) s1 +='0';
			else if(one>zero) s1 += '1';
		}

		return Integer.parseInt(s1, 2);
	}
}