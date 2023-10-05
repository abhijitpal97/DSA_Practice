package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/count-of-3s_1229406

public class CountOfThree_Moderate0510 {
	public static long countOf3(int x) {
		// Write your code here.
		long count = 0;
		for(int i=0;i<=x;i++)
		{
			String str = String.valueOf(i);
			char[] chars = str.toCharArray();
			for(char ch : chars)
			{
				if(ch == '3') count++;
			}
		}

		return count;
	}
}