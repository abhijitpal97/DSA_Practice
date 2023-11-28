package StriverSheet175AndLoveBabbar450;
import java.util.*;

// https://www.codingninjas.com/studio/problems/minimum-knight-moves_2179628

public class MinimumKnightMove 
{
    public static int minimumKnightMoves(int x, int y) 
    {
        // Write your code here
        int[][] dirs = new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});
        Map<String,Boolean> map = new HashMap<>();
        map.put("0#0",true);
        while(! queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int d = curr[2];

                if(r==x && c==y) return d;

                for(int[] dir : dirs)
                {
                    int cR = r+dir[0];
                    int cC = c+dir[1];
                    String key = cR+"#"+cC;
                    if(map.containsKey(key)) continue;
                    queue.offer(new int[]{cR,cC,d+1});
                }
            }
        }

        return -1;
    }   
}