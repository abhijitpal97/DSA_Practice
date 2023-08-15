package CodingNinjaPOTD;
import java.util.* ;
import java.io.*; 

public class LongestPath_Moderate1508 {
    public static int longestPath(int n, int m, int[][] mat, int sx, int sy, int dx, int dy) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        boolean[][] isVisited = new boolean[n][m];
        dfs(n,m,sx,sy,dx,dy,mat,isVisited,list,0);
        if(list.size()==0) return -1;
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    static void dfs(int n , int m , int sx , int sy , 
    int dx , int dy , int[][] mat , boolean[][] isVisited , List<Integer> list , int count)
    {
        if(sx==dx && sy==dy)
        {
            list.add(count);
            return;
        } 
        if(sx<0 || sx>=n || sy<0 || sy>=m ||
         mat[sx][sy] == 0 || isVisited[sx][sy]) return;

        isVisited[sx][sy] = true;
        dfs(n , m , sx , sy-1 , dx , dy , mat , isVisited , list , count+1);
        dfs(n , m , sx , sy+1 , dx , dy , mat , isVisited , list , count+1);
        dfs(n , m , sx-1 , sy , dx , dy , mat , isVisited , list , count+1);
        dfs(n , m , sx+1 , sy , dx , dy , mat , isVisited , list , count+1);
        isVisited[sx][sy] = false;

    }
}
