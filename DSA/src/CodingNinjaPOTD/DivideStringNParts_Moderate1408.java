package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/divide-string_1262345

public class DivideStringNParts_Moderate1408 {
	public static ArrayList<String> divideString(String word, int n) {
		// Write your code here
		int count = word.length();
		ArrayList<String> list = new ArrayList<>();
		if(count%n >0) return list;
		int perStr = count/n;

		while(word.length() != 0)
		{
			list.add(word.substring(0 , perStr));
			word = word.substring(perStr);
		}

		return list;
	}
}