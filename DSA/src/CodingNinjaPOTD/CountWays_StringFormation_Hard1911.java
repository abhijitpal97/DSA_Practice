package CodingNinjaPOTD;

// https://www.codingninjas.com/studio/problems/string-maker_975373

public class CountWays_StringFormation_Hard1911 {

	// Z * (x! + Y!)
	public static int countWays(String A, String B, String C) {
		int MOD = 1000000007;
		return solver(A, B, C, A.length(), B.length(), C.length(), MOD);
	}

	static int solver(String A, String B, String C, int x, int y, int z, int MOD) {
		// Base case if string C is complete.
		if (z == 0) {
			return 1;
		}

		// If C is not complete and both the strings are empty.
		if ((x <= 0 && y <= 0)) {
			return 0;
		}

		// Variable to store the total number of count.
		int ways = 0;

		// pick the zth char from string A.
		for (int i = x - 1; i >= 0; i--) {
			if (A.charAt(i) == C.charAt(z - 1)) {
				ways = (ways + solver(A, B, C, i, y, z - 1, MOD)) % MOD;
			}
		}

		// pick the zth char from string B.
		for (int i = y - 1; i >= 0; i--) {
			if (B.charAt(i) == C.charAt(z - 1)) {
				ways = (ways + solver(A, B, C, x, i, z - 1, MOD)) % MOD;
			}
		}

		return ways;
	}

	// Memorization 
	// X*Y*Z(X+Y)
	public static int countWaysMemo(String A, String B, String C) {
		int MOD = 1000000007;
		int x = A.length();
		int y = B.length();
		int z = C.length();
		Integer[][][] dp = new Integer[x+1][y+1][z+1];
		return solver(A, B, C, x,y,z,dp, MOD);
	}

	static int solver(String A, String B, String C, int x, int y, int z, 
			Integer[][][] dp , int MOD) {
		// Base case if string C is complete.
		if (z == 0) {
			return 1;
		}

		// If C is not complete and both the strings are empty.
		if ((x <= 0 && y <= 0)) {
			return 0;
		}

		if(dp[x][y][z] != null) return dp[x][y][z];
		// Variable to store the total number of count.
		int ways = 0;

		// pick the zth char from string A.
		for (int i = x - 1; i >= 0; i--) {
			if (A.charAt(i) == C.charAt(z - 1)) {
				ways = (ways + solver(A, B, C, i, y, z - 1, dp, MOD)) % MOD;
			}
		}

		// pick the zth char from string B.
		for (int i = y - 1; i >= 0; i--) {
			if (B.charAt(i) == C.charAt(z - 1)) {
				ways = (ways + solver(A, B, C, x, i, z - 1,dp, MOD)) % MOD;
			}
		}

		return ways;

	}


}