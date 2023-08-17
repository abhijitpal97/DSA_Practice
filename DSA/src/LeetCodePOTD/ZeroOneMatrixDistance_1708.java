package LeetCodePOTD;

import java.util.*;

public class ZeroOneMatrixDistance_1708 {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
                else mat[i][j] = -1;
            }
        }

        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        int length = 0;

        while( !queue.isEmpty())
        {
            int size = queue.size();
            length++;
            for(int i=0;i<size;i++)
            {
                int[] cell = queue.poll();
                for (int[] dir : dirs){
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];

                    if (r < 0 || c < 0 || r >= row || c >= col || mat[r][c] != -1) {
                        continue;
                    }

                    mat[r][c] = length;
                    queue.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}