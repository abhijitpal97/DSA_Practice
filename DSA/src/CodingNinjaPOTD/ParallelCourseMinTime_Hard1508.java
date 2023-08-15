package CodingNinjaPOTD;
import java.util.*;

public class ParallelCourseMinTime_Hard1508 {

    public static int parallelCourses(int n, int[][] prerequisites) {
        // Write your code here
        int[] inDegree = new int[n+1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] req : prerequisites)
        {
            adj.get(req[0]).add(req[1]);
            inDegree[req[1]]++;
        }
        int courseTaken = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i<=n;i++)
        {
            if(inDegree[i] == 0) 
            {
                courseTaken++;
                queue.offer(i);
            }
        }
        if(queue.isEmpty()) return -1;

        int result = 0;
        
        while(! queue.isEmpty())
        {
            int size = queue.size();
            result++;
            for(int i = 0; i<size;i++)
            {
                int curr = queue.poll();
                for(int j : adj.get(curr))
                {
                    inDegree[j]--;
                    if(inDegree[j] == 0)
                    {
                        courseTaken++;
                        queue.offer(j);
                    }
                }
            }
            
        }

        if(courseTaken != n) return -1;
        return result;
        
    }
}