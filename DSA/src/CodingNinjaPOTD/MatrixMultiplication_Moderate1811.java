package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// https://www.codingninjas.com/studio/problems/matrix-multiplication_1235204

public class MatrixMultiplication_Moderate1811 {
	public static ArrayList<ArrayList<Integer>> multiplyMatrices(ArrayList<ArrayList<Integer>> mat1, ArrayList<ArrayList<Integer>> mat2) {
		// Write your code here.
		int n = mat1.size();
		int m = mat1.get(0).size();
		int p =mat2.get(0).size();

		int[][] mat3 = new int[n][p];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<p;j++)
			{
				int sum = 0;
				for(int k=0;k<m;k++)
				{
					sum += mat1.get(i).get(k) * mat2.get(k).get(j);
				}
				mat3[i][j] = sum;
			}
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0;i<n;i++)
		{
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=0;j<p;j++)
			{
				temp.add(mat3[i][j]);
			}
			list.add(temp);
		}

		return list;
	}
}