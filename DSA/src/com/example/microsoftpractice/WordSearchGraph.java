package com.example.microsoftpractice;

public class WordSearchGraph {
    public boolean exist(char[][] board, String word) {
     int row = board.length;
     int col = board[0].length;

     for(int i=0;i<row;i++)
     {
         for(int j=0;j<col;j++)
         {
             boolean[][] isVisited = new boolean[row][col];
             if(board[i][j] == word.charAt(0))
             {
                 if(dfs(i , j , word , row , col , board,isVisited)) return true;
             }
         }
     }
     return false;   
    }

    boolean dfs(int r , int c , String word , int row , int col , char[][] board , boolean[][] isVisited)
    {
        if(word.length() == 0) return true;
        if(r<0 || r>=row || c<0 || c>=col || board[r][c] != word.charAt(0)|| isVisited[r][c]) return false;

        isVisited[r][c] = true;

        boolean le = dfs(r,c-1,word.substring(1),row,col,board,isVisited);
        boolean ri = dfs(r,c+1,word.substring(1),row,col,board,isVisited);
        boolean up = dfs(r-1,c,word.substring(1),row,col,board,isVisited);
        boolean dow = dfs(r+1,c,word.substring(1),row,col,board,isVisited);

        isVisited[r][c] = false;

        return le || ri || up || dow;
    }
}