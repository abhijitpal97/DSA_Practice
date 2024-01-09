package StriverSheet175AndLoveBabbar450;
// https://www.geeksforgeeks.org/problems/assembly-line-scheduling/1

public class CarAssembly {
	public static int carAssembly(int n, int[][] a, int[][] T, int[] e, int[] x) {
		// code here
		Integer[] dp1 = new Integer[n];
		Integer[] dp2 = new Integer[n];

		dp1[0] = e[0]+a[0][0];
		dp2[0] = e[1]+a[1][0];

		for(int i = 1;i<n;i++)
		{
			dp1[i] = Math.min(dp1[i-1]+a[0][i] ,
					dp2[i-1]+T[1][i]+a[0][i]);

			dp2[i] = Math.min(dp2[i-1]+a[1][i] ,
					dp1[i-1]+T[0][i]+a[1][i]);
		}

		return Math.min(dp1[n-1]+x[0] , dp2[n-1]+x[1]);

	}
}

