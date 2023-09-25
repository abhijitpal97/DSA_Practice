package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/double-strings_1461333

public class FindDoubleString 
{
	public static int findDoubleStrings(String str) 
	{
		// Write your code here.
		Set<String> set = new HashSet<>();
		int n = str.length();
		for(int i=0;i<n;i++)
		{
			String substr = "";
			for(int j=i;j<n;j++)
			{
				substr +=str.charAt(j);
				if(isDoubleString(substr)) set.add(substr);
			}
		}

		return set.size();
	}	

	static boolean isDoubleString(String str)
	{
		int mid = str.length()/2;
		return str.substring(0,mid).equals(str.substring(mid));
	}
}

