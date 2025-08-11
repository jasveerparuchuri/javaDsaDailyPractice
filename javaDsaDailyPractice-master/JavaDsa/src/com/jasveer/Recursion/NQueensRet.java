package com.jasveer.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueensRet {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<String>> result = solveNQueens(n);
        System.out.println("Output: " + result);
    }

    static ArrayList<ArrayList<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize board with dots ('.')
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        ArrayList<ArrayList<String>> allSolutions = new ArrayList<>();
        solve(board, 0, allSolutions);
        return allSolutions;
    }

    static void solve(char[][] board, int row, ArrayList<ArrayList<String>> results) {
        if (row == board.length) {
            results.add(copyBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1, results);
                board[row][col] = '.';  // Backtrack
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    static ArrayList<String> copyBoard(char[][] board) {
        ArrayList<String> snapshot = new ArrayList<>();
        for (char[] row : board) {
            snapshot.add(new String(row));
        }
        return snapshot;
    }
}
