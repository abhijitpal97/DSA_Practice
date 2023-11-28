package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 
// https://www.codingninjas.com/studio/problems/find-if-there-is-a-path-of-more-than-k-length-from-a-source_1229512

public class PathMoreThanDistanceK {
	public static String pathMoreThanK(int n, int m, int k, int[][] edges) {
		// Write your code here.
		List<List<int[]>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) adj.add(new ArrayList<>());
		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(new int[]{edge[1] , edge[2]});
			adj.get(edge[1]).add(new int[]{edge[0] , edge[2]});
		}
		boolean[] isVisited = new boolean[n];

		return dfs(0 , adj , isVisited , n , 0 , k)==true?"YES":"NO";
	}

	static boolean dfs(int src , List<List<int[]>> adj , boolean[] isVisited , int n , int curr , int target)
	{
		if(curr > target) return true;
		isVisited[src] = true;

		for(int[] dest : adj.get(src))
		{
			if(! isVisited[dest[0]])
			{
				if(dfs(dest[0] , adj , isVisited , n , curr+dest[1] ,  target)) return true;
			}
		}

		isVisited[src] = false;
		return false;
	}
}
