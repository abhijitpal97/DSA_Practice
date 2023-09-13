package com.example.amazonpractice;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int sRow = 0;
        int sCol = col-1;

        while(sRow<row && sCol>=0)
        {
          if(target<matrix[sRow][sCol]) sCol--;
          else if(target>matrix[sRow][sCol]) sRow++;
          else return true;
        }

        return false;
    }
}