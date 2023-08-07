package LeetCodePOTD;

public class SearchIn2DMatrix_0708 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int colPos = matrix[0].length-1;
        int i = 0;
        while(i<matrix.length)
        {
            if(matrix[i][colPos] == target) return true;
            else if(matrix[i][colPos] < target) i++;
            else if(matrix[i][colPos] > target) colPos--;
            if(colPos < 0) return false;
        } 
        return false;
    }
}