package StriverSheet175AndLoveBabbar450;
import java.util.* ;
import java.io.*; 

// https://www.codingninjas.com/studio/problems/kill-the-snipers-ii_1171163

public class Snipper2
{
    public static int[] minTime(int n, int m, int[][] edges)
    {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] inDegree = new int[n];
        int[] res = new int[n];
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(inDegree[i] == 0)
            {
                queue.offer(i);
                res[i] = 1;
            }
        }

        while(! queue.isEmpty())
        {
            int curr = queue.poll();

            for(int i : adj.get(curr))
            {
                inDegree[i]--;
                if(inDegree[i] == 0)
                {
                    res[i] = res[curr]+1;
                    queue.offer(i);
                }
            }
        }

        return res;
    }
}

