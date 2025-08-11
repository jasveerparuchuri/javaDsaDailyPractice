package com.jasveer.Recursion;

class RatInMaze{
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },{ 1, 1, 0, 1 },{ 0, 1, 0, 0 },{ 1, 1, 1, 1 } };
        ratMaze(" ",maze,0,0);
    }
    static void ratMaze(String p ,int[][] maze , int row,int col){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(maze[row][col] == 0){
            return;
        }
        maze[row][col] = 0;
        if(row < maze.length-1){
            ratMaze(p+"D",maze,row+1,col);
        }
        if(col < maze[0].length-1){
            ratMaze(p+"R",maze,row,col+1);
        }
        if(row > 0){
            ratMaze(p+"U",maze,row-1,col);
        }
        if(col > 0){
            ratMaze(p+"L",maze,row,col-1);
        }
        maze[row][col] = 1;
    }
}