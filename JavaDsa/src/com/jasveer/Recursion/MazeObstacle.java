package com.jasveer.Recursion;

public class MazeObstacle {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true ,true, true},
                {true ,false, true},
                {true ,true, true}
        };
        mazeobs(" " ,maze ,maze.length-1,maze[0].length-1);
    }
    public static  void mazeobs(String p ,boolean[][] maze,int r, int c){
        if(r == 0 && c == 0){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r > 0) {
            mazeobs(p + "D", maze,r - 1, c);
        }
        if(c>0) {
            mazeobs(p + "r",maze, r, c - 1);
        }
    }
}
