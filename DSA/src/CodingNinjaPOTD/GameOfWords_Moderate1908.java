package CodingNinjaPOTD;

import java.util.* ;
import java.io.*; 

public class GameOfWords_Moderate1908 {
	public static ArrayList<Integer> getFrequency(String str, ArrayList<String> words, int n) {
		String[] strArr = str.split(" ");

		// Splitting 'STR' by spaces and storing in vector.
		ArrayList<Integer> answer = new ArrayList<>(n);
		HashMap<String, Integer> mp = new HashMap<>();

		for (String strWord : strArr) {
			if (!mp.containsKey(strWord)) {
				mp.put(strWord, 1);
			} else {
				mp.put(strWord, mp.get(strWord) + 1);
			}

		}
		//System.out.println(mp);

		for (String word : words) {
			if (mp.containsKey(word)) {
				answer.add(mp.get(word));
			} else {
				answer.add(0);
			}
		}

		return answer;
	}
}
