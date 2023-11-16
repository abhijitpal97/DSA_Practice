package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/remove-invalid-parentheses_1263697

public class RemovalInvaliParenthesisUnique_Hard1511 {
	static int minRemoval = Integer.MAX_VALUE;
	public static ArrayList<String> removeInvalidParentheses(String str) {
		// Write your code here.
		minRemoval = Integer.MAX_VALUE;
		HashSet<String> set = new HashSet<>();
		String resSoFar = "";

		removeRecursively(str,0,resSoFar,0,0,0,set);

		ArrayList<String> list = new ArrayList<>();
		for(String ans : set) list.add(ans);

		return list;
	}

	public static void removeRecursively(String str, int index, String resultSoFar, int leftCount, int rightCount,
			int removeCount, HashSet<String> hashSet) {
		// Base case.
		if (index == str.length()) {
			// Valid String is found.
			if (leftCount == rightCount) {
				if (removeCount <= minRemoval) {
					if (removeCount < minRemoval) {
						hashSet.clear();
						minRemoval = removeCount;
					}
					hashSet.add(resultSoFar);
				}
			}
		} else {

			// If current character is not parenthesis, include it in 'possibleAnswer'.
			if (str.charAt(index) != '(' && str.charAt(index) != ')') {
				resultSoFar += (str.charAt(index));
				removeRecursively(str, index + 1, resultSoFar, leftCount, rightCount, removeCount, hashSet);

				// Remove last character
				resultSoFar = resultSoFar.substring(0, resultSoFar.length() - 1);
			} else
				// For parenthesis, two cases: Include or Exclude
			{
				// Include Case.
				resultSoFar += (str.charAt(index));
				if (str.charAt(index) == '(') {
					removeRecursively(str, index + 1, resultSoFar, leftCount + 1, rightCount, removeCount, hashSet);
				} else if (leftCount > rightCount) {
					removeRecursively(str, index + 1, resultSoFar, leftCount, rightCount + 1, removeCount, hashSet);
				}

				// Remove last character.
				resultSoFar = resultSoFar.substring(0, resultSoFar.length() - 1);

				// Exclude Case.
				removeRecursively(str, index + 1, resultSoFar, leftCount, rightCount, removeCount + 1, hashSet);
			}

		}
	}
}
