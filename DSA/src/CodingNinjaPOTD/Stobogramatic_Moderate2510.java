package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/strobogrammatic-number_1462452

public class Stobogramatic_Moderate2510  {

	public static boolean isStrobogrammatic(String n){
		// Write your code here.
		int start = 0;
		int end = n.length()-1;

		while(start<=end)
		{
			char f1 = n.charAt(start);
			char f2 = n.charAt(end);
			if((f1=='9' && f2=='6') || ((f1=='6' && f2=='9')) ||
					((f1=='1' && f2=='1') || (f1=='8' && f2=='8')) || 
					(f1=='0' && f2=='0'))
			{
				start++;
				end--;
			}
			else return false;
		}

		return true;
	}

}