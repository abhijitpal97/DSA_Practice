package CodingNinjaPOTD;

/*
    Time Complexity: O((N * M) ^ 2)
    Space Complexity: O(N * M)

    Where N is the number of rows and M is the number of columns.
 */

import java.util.*;
public class MeetUp_Hard0309 {

	public static void bfs(int x, int y, String[] grid, int[][] dis){

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0 , 0, 1, -1};

		int n = grid.length;
		int m = grid[0].length();

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[]{x, y});
		dis[x][y] = 0;

		while (q.size() > 0)
		{
			int[] p = q.remove();
			x = p[0];
			y = p[1];

			for (int i = 0; i < 4; i++)
			{
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX < 0 || newY < 0 || newX >= n || newY >= m)
				{   
					// Out of the range of the grid.
					continue;
				}
				if (dis[newX][newY] == -1 && grid[newX].charAt(newY) == '.')
				{   
					dis[newX][newY] = dis[x][y] + 1;
					q.add(new int[]{newX, newY});
				}
			}
		}
	}

	public static int meetup(String[] grid) {

		int n = grid.length;
		int m = grid[0].length();

		// Creating 2d vector to store the sum of distance travelled by all the friends.
		int[][] totalDis = new int[n][m];

		// Creating 2d vector to store the count of friends that can reach that spot.
		int[][] vis = new int[n][m];

		// Variable to count the number of total friends.
		int countFriends = 0;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (grid[i].charAt(j) == 'F')
				{   

					countFriends++;

					//  Creating 2d vector to store the shortest distance from the current point.
					int[][] dis = new int[n][m];

					for(int k = 0; k < n; k++){
						for(int l = 0; l < m; l++){
							dis[k][l] = -1;
						}
					}
					// Calling bfs funtion. 
					bfs(i, j, grid, dis);

					for (int k = 0; k < n; k++)
					{
						for (int l = 0; l < m; l++)
						{
							if (dis[k][l] != -1)
							{   
								// Current friend can visit point (k,l).
								vis[k][l]++;
								totalDis[k][l] += dis[k][l];
							}
						}
					}
				}
			}
		}

		int ans = -1;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (grid[i].charAt(j) == '.' && vis[i][j] == countFriends)
				{   
					// All friends can reach the current spot.
					if (ans == -1 || ans > totalDis[i][j])
					{   
						// Storing the minimum sum of distance.
						ans = totalDis[i][j];
					}
				}
			}
		}
		return ans;
	}
}