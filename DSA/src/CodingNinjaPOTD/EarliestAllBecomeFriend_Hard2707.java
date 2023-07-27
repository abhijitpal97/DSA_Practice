package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class EarliestAllBecomeFriend_Hard2707 {
	
	public static void main(String[] args)
	{
		int res = minTime(new int[][] {{77,0,1},{79,0,2},{21,0,3} , {66,0,4}}, 4);
		int res1 = minTime(new int[][] {{51,0,1},{55,0,2},{1,0,3} , 
			{29,1,2} , {53,1,3}}, 5);
		System.out.println(res);
		System.out.println(res1);
	}
	
	public static int minTime(int[][] logs, int n) {
		// Write your code here.
		Arrays.sort(logs , (a,b) -> a[0]-b[0]);
		Set<Integer> set = new HashSet<>();
		for(int i =0 ;i<n;i++)
		{
			set.add(logs[i][1]);
			set.add(logs[i][2]);
		}
		int m = set.size();
		int[] parent = new int[m];
		for(int i=0;i<m;i++) parent[i] = i;
		int min = Integer.MIN_VALUE;
		for(int i =0 ;i<n;i++)
		{
			int src = logs[i][1];
			int dest = logs[i][2];
			int time = logs[i][0];

			int x = find(src , parent);
			int y = find(dest , parent);
			if(x==y) continue;
			union(x , y , parent);
			min = Math.max(min,time);
		}
		Set<Integer> dis = new HashSet<>();
		for(int i=0;i<m;i++) 
		{
			dis.add(parent[i]);
		}
		return dis.size()>1?-1:min;
	}

	static int find(int x , int[] parent)
	{
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x] , parent);
	}

	static void union(int a , int b , int[] parent)
	{
		int x = find(a,parent);
		int y = find(b,parent);
		if(x==y) return;
		parent[y] = x;
	}
}

