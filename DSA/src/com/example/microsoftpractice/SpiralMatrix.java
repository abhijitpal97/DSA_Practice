package com.example.microsoftpractice;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        
        int left=0;
        int right=col-1;
        int top=0; 
        int down = row-1;
        int count =0;
        int totalele = row*col;
        

        List<Integer> list = new ArrayList<>();

        while(count<totalele)
        {
            //left to right
            for(int i = left; i<=right && count<totalele;i++)
            {
                list.add(matrix[top][i]);
                count++;
            }
            top++;
            //top to down
            for(int i = top;i<=down && count<totalele; i++)
            {
                list.add(matrix[i][right]);
                count++;
            }
            right--;
            //right to left
            for(int i = right; i >=left && count<totalele ; i--)
            {
                list.add(matrix[down][i]);
                count++;
            }
            down--;
            //down to up
            for(int i=down ; i>= top && count<totalele ; i--)
            {
                list.add(matrix[i][left]);
                count++;
            }
            left++;
        }

        return list;
        
    }
}