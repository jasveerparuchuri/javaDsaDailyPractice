package com.jasveer.Recursion;



public class NOueens {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        sloveQueen(board,0);
    }
    public static void sloveQueen(char[][] board,int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return;
        }
        for(int j = 0; j< board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                sloveQueen(board,row+1);
                board[row][j] = '.';
            }
        }
    }
    public static boolean isSafe(char[][] board ,int row,int col){
        // for vertical up
        for(int i= row-1; i>=0;i--){
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonalleft
        int minLeft = Math.min(row,col);
        for(int i = 1;i<=minLeft;i++){
            if(board[row-i][col-i] == 'Q') {
                return false;
            }
        }
        int minRight = Math.min(row, board.length -col-1);
        for(int i = 1;i<=minRight;i++){
            if(board[row-i][col+i] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public static void display(char[][] board){
        for(char[] row :board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
