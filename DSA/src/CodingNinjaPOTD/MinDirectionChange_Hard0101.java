package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

class FourSide
{
	int r;
	int c;
	int cost;

	FourSide(int r , int c , int cost)
	{
		this.r=r;
		this.c=c;
		this.cost=cost;
	}
}

public class MinDirectionChange_Hard0101 {

	public static void main(String[] args)
	{
		int res = minDirectionChanges(new char[][] {{'L','U'},{'D','R'},{'L','R'}}, 3, 2);
		System.out.println(res);
	}
	public static int minDirectionChanges(char[][] grid, int n, int m) {
		// Write your code here
		Queue<FourSide> queue = new PriorityQueue<>((a,b) -> a.cost-b.cost);
		boolean[][] isVisited = new boolean[n][m];
		isVisited[0][0] = true;
		queue.offer(new FourSide(0,0,0));

		while(! queue.isEmpty())
		{
			int size = queue.size();
			//System.out.println("Size - "+size);
			for(int i=0;i<size;i++)
			{
				FourSide curr = queue.poll();
				int r = curr.r;
				int c = curr.c;
				int cost = curr.cost;

				int mR=0;
				int mC=0;
				if(grid[r][c] == 'R')
				{
					mC=1;
				}
				else if(grid[r][c] == 'L')
				{
					mC=-1;
				}
				if(grid[r][c] == 'U')
				{
					mR=-1;
				}
				if(grid[r][c] == 'D')
				{
					mR=1;
				}

				//System.out.println(r+"-"+c+"-"+cost+"-"+grid[r][c]+"-"+mR+"-"+mC+"\n");
				if(r==n-1 && c==m-1) return cost;

				int cR = r+mR;
				int cC = c+mC;
				if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
				{
					queue.offer(new FourSide(cR,cC,cost));
					isVisited[cR][cC] = true;
				}

				if(mR == 0 && mC == 1)
				{
					cR = r;
					cC = c-1;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r-1;
					cC = c;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r+1;
					cC = c;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}
				}

				else if(mR == 0 && mC == -1)
				{
					cR = r;
					cC = c+1;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r-1;
					cC = c;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r+1;
					cC = c;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}
				}

				else if(mR == 1 && mC == 0)
				{
					cR = r;
					cC = c-1;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r-1;
					cC = c;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r;
					cC = c+1;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}
				}

				else if(mR == -1 && mC == 0)
				{
					cR = r;
					cC = c-1;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r;
					cC = c+1;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}

					cR = r+1;
					cC = c;
					if(cR>=0 && cR<n && cC>=0 && cC<m && !isVisited[cR][cC])
					{
						queue.offer(new FourSide(cR,cC,cost+1));
						isVisited[cR][cC] = true;
					}
				}
			}
		}

		return -1;
	}
}