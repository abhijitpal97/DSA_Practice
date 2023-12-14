package CodingNinjaPOTD;

import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/ninja-s-academy_1376438

public class CourseSequeunce_Hard1112 {
	static int[] visit = new int[101];
	public static ArrayList<Boolean> ninjaAcademy(int n, int prerequisite[][], int query[][]) {
		// Write your code here.
		List<Set<Integer>> set = new ArrayList<>();
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			adj.add(new ArrayList<>());
			set.add(new HashSet<>());
		}

		for(int[] pre : prerequisite)
		{
			adj.get(pre[0]).add(pre[1]);
		}



		ArrayList<Boolean> result = new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			Arrays.fill(visit , 0);
			dfs(i,set.get(i),adj);
		}

		for(int[] que : query)
		{
			result.add(set.get(que[0]).contains(que[1]));
		}

		return result;
	}

	public static void dfs(int n, Set<Integer> s, List<List<Integer>> p) {
		s.add(n);
		visit[n] = 1;
		for (int i = 0; i < p.get(n).size(); i++) {
			if (visit[p.get(n).get(i)] == 0) {
				dfs(p.get(n).get(i), s, p);
			}
		}
	}
}
