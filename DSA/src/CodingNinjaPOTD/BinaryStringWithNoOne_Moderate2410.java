package CodingNinjaPOTD;
import java.util.*;

// https://www.codingninjas.com/studio/problems/binary-strings-with-no-consecutive-1s_893001

public class BinaryStringWithNoOne_Moderate2410 {
	public static List< String > generateString(int N) {
		// Write your code here.
		List<String> list = new ArrayList<>();
		if(N == 0) return list;

		function(new String("0") , 1 , '0' , N , list);
		function(new String("1") , 1 , '1' , N , list);

		Collections.sort(list);
		return list;
	}

	static void function(String str , int index , char prev , int n , List<String> list)
	{
		if(index >= n)
		{
			if(! list.contains(str))list.add(str);
			return;
		}

		if(prev == '0')
		{
			function(str+'1' , index+1 , '1' , n , list);
			function(str+'0' , index+1 , '0' , n , list);
		}
		else if(prev == '1') 
		{
			function(str+'0' , index+1 , '0' , n , list);
		}
	}
}
