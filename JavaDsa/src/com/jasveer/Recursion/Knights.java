package com.jasveer.Recursion;

public class Knights {
    public static void main(String[] args) {
        int[][] board = new int[4][];
        knightsTour(board,0);
    }
    public static void knightsTour(int[][] board,int row){
        if(row == board.length-1){
            display(board);
            return;
        }
        for(int j = 0;j<board.length;j++){
            if(isSafeValue(board , row,j)){
                board[row][j] = 1;
                knightsTour(board,row+1);
                board[row][j] = 0;
            }

        }

    }
    public static boolean isSafeValue(int[][] board ,int row, int col){
        int l = board.length;
        // up right
        for(int i = row-1;i >= 0;i--){
            if(board[i][col+1] == 1){
                return false;
            }
        }
        // up left
        for(int i = row-1;i >= 0;i--){
            if(board[i][col-1] == 1){
                return false;
            }
        }
        // left up
        for(int i = col-1;i<l;i++){
            if(board[row-1][i] == 1){
                return false;
            }
        }
        // right down
        for(int i = col-1;i<l;i++){
            if(board[row+1][i] == 1){
                return false;
            }
        }
        for(int i = row-1;i <l;i++){
            if(board[i][col+1] == 1){
                return false;
            }
        }
        for(int i = row-1;i <l;i++){
            if(board[i][col-1] == 1){
                return false;
            }
        }
        for(int i = col-1 ; i>=0;i++){
            if(board[row-1][i]==1){
                return false;
            }
        }
        for(int i = col-1 ; i>=0;i++){
            if(board[row+1][i]==1){
                return false;
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for(int[] row : board){
            for(int col : row){
                System.out.println(col);
            }
        }
    }
}
