package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 
import java.util.List;

// https://www.codingninjas.com/studio/problems/sorted-matrix_758931

public class SortedMatrix {

	public static List<Integer> sortedMatrix(int[][] mat, int n) {
		// Write your code here.
		Queue<Integer> queue = new PriorityQueue<>();
		int row = mat.length;
		int col = mat[0].length;

		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				queue.offer(mat[i][j]);
			}
		}

		List<Integer> list = new ArrayList<>();
		while( ! queue.isEmpty())
		{
			list.add(queue.poll());
		}

		return list;

	}

}
