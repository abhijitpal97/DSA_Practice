package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/manacher-s-algorithm_3155502

public class ManacharsAlgorithm_Hard0911 {

	public static String manacherAlgo(String str) {
		// Write your code here.
		int start = 0;
		int end = 0;
		int maxLen = 0;
		String s = "";

		for(int i = 0 ; i<str.length() ; i++)
		{
			int len1 = palindromicLen(str , i , i);
			int len2 = palindromicLen(str , i , i+1);
			int len = Math.max(len1,len2);

			if(len>end-start)
			{
				start = i - ((len-1)/2) ;
				end = i+(len/2);

				if(end-start+1 > maxLen)
				{
					maxLen = Math.max(maxLen , end-start+1);
					s = str.substring(start , end+1);
				}
			}
		}

		return s;
	}

	static int palindromicLen(String str , int start , int end)
	{
		if(str.length() == 0) return 0;
		while(start>=0 && end<str.length() && str.charAt(start) == str.charAt(end))
		{
			start--;
			end++;
		}

		return end-start-1;
	}

}
