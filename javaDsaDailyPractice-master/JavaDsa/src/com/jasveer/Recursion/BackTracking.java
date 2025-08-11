package com.jasveer.Recursion;
import  java.util.*;
public class BackTracking {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true ,true, true},
                {true ,true, true},
                {true ,true, true}
        };
        int[][] arr = new int[maze.length][maze[0].length];
        mazeAllDirection("" , maze,0,0,arr ,1);
    }
//    public static  void mazeAllDirection(String p,boolean[][] maze,int r,int c){
//        if(r == maze.length-1 && c == maze[0].length-1){
//            System.out.println(p);
//            return;
//        }
//        if(!maze[r][c]){
//            return;
//        }
//        maze[r][c] = false; // mark the cell
//        if(r < maze.length-1){
//            mazeAllDirection(p+"D" , maze,r+1,c);
//        }
//        if(c < maze[0].length-1){
//            mazeAllDirection(p+"R" , maze,r,c+1);
//        }
//        if(r > 0){
//            mazeAllDirection(p+"U" , maze,r-1,c);
//        }
//        if(c > 0){
//            mazeAllDirection(p+"L" , maze,r,c-1);
//        }
//        maze[r][c] = true; // unmark the cell
//    }

    public static  void mazeAllDirection(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for(int[] i : path){
                System.out.println(Arrays.toString(i));
            }
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c] = false; // mark the cell
        path[r][c] = step;
        if(r < maze.length-1){
            mazeAllDirection(p+"D" , maze,r+1,c,path,step+1);
        }
        if(c < maze[0].length-1){
            mazeAllDirection(p+"R" , maze,r,c+1,path,step+1);
        }
        if(r > 0){
            mazeAllDirection(p+"U" , maze,r-1,c,path,step+1);
        }
        if(c > 0){
            mazeAllDirection(p+"L" , maze,r,c-1,path,step+1);
        }
        maze[r][c] = true; // unmark the cell
        path[r][c]  = 0;
    }
}
