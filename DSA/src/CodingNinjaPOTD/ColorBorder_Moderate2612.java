package CodingNinjaPOTD;

import java.util.LinkedList;
import java.util.Queue;

// https://www.codingninjas.com/studio/problems/border_color_3164684

public class ColorBorder_Moderate2612 
{
    public static int[][] color_border(int n, int m, int new_color, int row, int col,int[][] matrix)
	{

		int ans[][] = new int[n][m];
		int visited[][] = new int[n][m];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{row,col});
		visited[row][col] = 1;
		
		int dirs[][] =  {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

		// BFS to find the cells which are connected to the cell (row, col).
		while(q.size() > 0)
		{
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			
			for(int[] dir : dirs)
			{
				int k = x+dir[0];
				int l = y+dir[1];

				if ((0 <= k) && (k < n) && (0 <= l) && (l < m) 
                && (matrix[x][y] == matrix[k][l]) && (visited[k][l] == 0))
				{	
					q.add(new int[]{k,l});
					visited[k][l] = 1;
				}
			}
		}
	
		// Change the color of the cells which are connected to the cell (row, col)
		// and lie on the border.
	
		for(int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				int c = 0;
				for(int[] dir : dirs)
			    {
				    int k = i+dir[0];
				    int l = j+dir[1];

				    if ((0 <= k) && (k < n) && (0 <= l) && (l < m) 
                    && (matrix[i][j] == matrix[k][l]))
				    {
						c += 1;
					}
				}
				if ((c < 4) && (visited[i][j] == 1))
				{
					ans[i][j] = new_color;
				}
				else
				{
					ans[i][j] = matrix[i][j];
				}
			}
		}
	
		return ans;
    }
}