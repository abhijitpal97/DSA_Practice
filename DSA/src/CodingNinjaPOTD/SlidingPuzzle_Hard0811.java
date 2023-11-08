package CodingNinjaPOTD;
/*
	Time Complexity : O(1)
	Space Complexity : O(1)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

// https://www.codingninjas.com/studio/problems/sliding-puzzle_1266108

class PairSlidingPuzzle<T, P> {
	public T first;
	public P second;

	public PairSlidingPuzzle(T f, P s) {
		first = f;
		second = s;
	}
}

public class SlidingPuzzle_Hard0811 {
	// Function to convert matrix to string.
	public static String convert(List<List<Integer>> matrix) {
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				answer.append(matrix.get(i).get(j));
			}
		}
		return answer.toString();
	}

	// Returns the index of 0 in string.
	public static int findPos(String curNode) {
		for (int i = 0; i < 2 * 3; i++) {
			if (curNode.charAt(i) == '0') {
				return i;
			}
		}
		return -1;
	}

	public static int slidingPuzzle(List<List<Integer>> board) {
		// Target matrix.
		List<List<Integer>> target = new ArrayList<>();
		target.add(Arrays.asList(1, 2, 3));
		target.add(Arrays.asList(4, 5, 0));

		int moves = 0;

		int n = board.size(), m = board.get(0).size();


		Queue<PairSlidingPuzzle<Integer, String>> que = new LinkedList<>();

		int dr[] = { 0, 1, 0, -1 };
		int dc[] = { 1, 0, -1, 0 };

		que.add(new PairSlidingPuzzle<Integer, String>(moves, convert(board)));
		HashMap<String, Boolean> mp = new HashMap<>();

		while (que.isEmpty() == false) {
			String curNode = que.peek().second;
			int mv = que.peek().first;
			que.remove();

			// Converting target matrix to string.
			String t = convert(target);
			if (curNode.equals(t)) {
				return mv;
			}
			if (mp.get(curNode) != null && mp.get(curNode)) {
				// If we have already seen this state then continue.
				continue;
			} else {
				mp.put(curNode, true);

				int zeroPos = findPos(curNode);
				// Indices of zeroPos in the matrix.
				int r = zeroPos / 3, c = zeroPos % 3;

				for (int i = 0; i < 4; i++) {
					// Checking for overflow conditions.
					if ((r + dr[i] >= 0 && r + dr[i] < n) && (c + dc[i] >= 0 && c + dc[i] < m)) {

						StringBuilder tempString = new StringBuilder(curNode);

						// Swapping the values with zero.
						char toSwap = tempString.charAt(zeroPos);
						// Multiplying by 3 to get index in string because (r + dr[i]) is index of matrix.
						tempString.setCharAt(zeroPos, tempString.charAt(3 * (r + dr[i]) + c + dc[i]));
						tempString.setCharAt(3 * (r + dr[i]) + c + dc[i], toSwap);

						String check = tempString.toString();

						if (!mp.containsKey(check)) {
							que.add(new PairSlidingPuzzle<Integer, String>(mv + 1, check));
						}

						// Swapping the values again to maintian curNode's previous value.
						char toSwap2 = tempString.charAt(zeroPos);
						tempString.setCharAt(zeroPos, tempString.charAt(3 * (r + dr[i]) + c + dc[i]));
						tempString.setCharAt(3 * (r + dr[i]) + c + dc[i], toSwap2);

						curNode = tempString.toString();
					}
				}
			}
		}
		return -1;
	}
}
