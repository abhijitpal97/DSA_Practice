package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/hard_6581609

public class GivenWordCheck_Hard1110
{
	public static boolean[] checkWordsInString(String s, int n, ArrayList<String> wordList) 
	{
		// Write your code here
		boolean[] result = new boolean[n];
		int index = 0;
		for(String word : wordList)
		{
			if(s.indexOf(word) != -1) result[index] = true;
			else result[index] = false;
			index++;
		}

		return result;
	}
}
