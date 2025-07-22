package com.jasveer.Project;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Sudoku extends JFrame {
    private JTextField[][] cells = new JTextField[9][9];
    private JButton checkButton, solveButton, resetButton, undoButton, hintButton;
    private Timer gameTimer;
    private int secondsPassed = 0;
    private JLabel timerLabel;
    private JComboBox<String> levelSelector;
    private String currentLevel = "Easy";

    private Stack<Move> moveStack = new Stack<>();

    private final int[][] easyPuzzle = {
            { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
            { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
            { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
            { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
            { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
            { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
            { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
            { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
            { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
    };

    private final int[][] mediumPuzzle = {
            { 0, 2, 0, 6, 0, 8, 0, 0, 0 },
            { 5, 8, 0, 0, 0, 9, 7, 0, 0 },
            { 0, 0, 0, 0, 4, 0, 0, 0, 0 },
            { 3, 7, 0, 0, 0, 0, 5, 0, 0 },
            { 6, 0, 0, 0, 0, 0, 0, 0, 4 },
            { 0, 0, 8, 0, 0, 0, 0, 1, 3 },
            { 0, 0, 0, 0, 2, 0, 0, 0, 0 },
            { 0, 0, 9, 8, 0, 0, 0, 3, 6 },
            { 0, 0, 0, 3, 0, 6, 0, 9, 0 }
    };

    private final int[][] hardPuzzle = {
            { 0, 0, 0, 0, 0, 0, 0, 1, 2 },
            { 0, 0, 0, 0, 0, 0, 7, 0, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 5, 0, 0, 0 },
            { 4, 0, 0, 3, 0, 0, 0, 0, 0 },
            { 0, 9, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 7, 0, 0, 3, 0, 0 },
            { 3, 0, 0, 0, 0, 0, 6, 0, 0 },
            { 0, 0, 0, 9, 0, 0, 0, 0, 0 }
    };

    private int[][] currentPuzzle = easyPuzzle;
    private int[][] solvedPuzzle = new int[9][9];

    public Sudoku() {
        setTitle("Sudoku Solver with Backtracking ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        Font font = new Font("Arial", Font.BOLD, 28);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField tf = new JTextField();
                tf.setHorizontalAlignment(JTextField.CENTER);
                tf.setFont(font);
                int top = (i % 3 == 0) ? 3 : 1;
                int left = (j % 3 == 0) ? 3 : 1;
                int bottom = (i == 8) ? 3 : 1;
                int right = (j == 8) ? 3 : 1;
                tf.setBorder(new MatteBorder(top, left, bottom, right, Color.BLACK));
                final int row = i, col = j;
                tf.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        if (tf.isEditable()) {
                            String text = tf.getText().trim();
                            if (text.matches("[1-9]")) {
                                moveStack.push(new Move(row, col, ""));
                            } else {
                                tf.setText("");
                            }
                        }
                    }
                });
                cells[i][j] = tf;
                gridPanel.add(tf);
            }
        }

        JPanel topPanel = new JPanel();
        levelSelector = new JComboBox<>(new String[] { "Easy", "Medium", "Hard" });
        levelSelector.addActionListener(e -> {
            String level = (String) levelSelector.getSelectedItem();
            switch (level) {
                case "Easy" -> currentPuzzle = easyPuzzle;
                case "Medium" -> currentPuzzle = mediumPuzzle;
                case "Hard" -> currentPuzzle = hardPuzzle;
            }
            currentLevel = level;
            setupInitialPuzzle();
            solvedPuzzle = copyBoard(currentPuzzle);
            solveSudoku(solvedPuzzle);
        });

        timerLabel = new JLabel("Time: 00:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerLabel.setForeground(Color.BLUE);
        gameTimer = new Timer(1000, e -> updateTimer());

        topPanel.add(new JLabel("Difficulty:"));
        topPanel.add(levelSelector);
        topPanel.add(Box.createHorizontalStrut(20));
        topPanel.add(timerLabel);

        JPanel bottomPanel = new JPanel();
        checkButton = new JButton("Check");
        checkButton.addActionListener(e -> checkSolution());

        solveButton = new JButton("Auto Solve");
        solveButton.addActionListener(e -> {
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {
                    cells[i][j].setText(String.valueOf(solvedPuzzle[i][j]));
                    cells[i][j].setEditable(false);
                    cells[i][j].setBackground(Color.GREEN);
                }
            stopTimer();
        });

        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            setupInitialPuzzle();
            solvedPuzzle = copyBoard(currentPuzzle);
            solveSudoku(solvedPuzzle);
        });

        undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> {
            if (!moveStack.isEmpty()) {
                Move move = moveStack.pop();
                cells[move.row][move.col].setText(move.prevValue);
            }
        });

        hintButton = new JButton("Hint!");
        hintButton.addActionListener(e -> {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (cells[i][j].isEditable() && cells[i][j].getText().isEmpty()) {
                        cells[i][j].setText(String.valueOf(solvedPuzzle[i][j]));
                        cells[i][j].setBackground(new Color(255, 255, 180));
                        return;
                    }
                }
            }
        });

        bottomPanel.add(checkButton);
        bottomPanel.add(solveButton);
        bottomPanel.add(resetButton);
        bottomPanel.add(undoButton);
        bottomPanel.add(hintButton);

        add(topPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setupInitialPuzzle();
        solvedPuzzle = copyBoard(currentPuzzle);
        solveSudoku(solvedPuzzle);

        setPreferredSize(new Dimension(700, 800));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupInitialPuzzle() {
        moveStack.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int val = currentPuzzle[i][j];
                cells[i][j].setText(val == 0 ? "" : String.valueOf(val));
                cells[i][j].setEditable(val == 0);
                cells[i][j].setBackground(val == 0 ? Color.WHITE : Color.LIGHT_GRAY);
            }
        }
        startTimer();
    }

    private int[][] copyBoard(int[][] source) {
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(source[i], 0, copy[i], 0, 9);
        }
        return copy;
    }

    private boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }
        return true;
    }

    private void updateTimer() {
        int minutes = secondsPassed / 60;
        int seconds = secondsPassed % 60;
        timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
        secondsPassed++;
    }

    private void startTimer() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
        secondsPassed = 0;
        gameTimer.start();
        updateTimer();
    }

    private void stopTimer() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
    }

    private void checkSolution() {
        int[][] board = new int[9][9];
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String text = cells[i][j].getText().trim();
                    if (text.isEmpty()) {
                        board[i][j] = 0;
                    } else {
                        int val = Integer.parseInt(text);
                        if (val < 1 || val > 9) throw new NumberFormatException();
                        board[i][j] = val;
                    }
                }
            }
            if (isCorrectSolution(board)) {
                stopTimer();
                JOptionPane.showMessageDialog(this, "Congratulations! Sudoku is correct.");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect solution. Try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Only numbers 1–9 allowed!");
        }
    }

    private boolean isCorrectSolution(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[10];
            boolean[] col = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int r = board[i][j];
                int c = board[j][i];
                if (r == 0 || row[r]) return false;
                if (c == 0 || col[c]) return false;
                row[r] = true;
                col[c] = true;
            }
        }
        for (int rowStart = 0; rowStart < 9; rowStart += 3) {
            for (int colStart = 0; colStart < 9; colStart += 3) {
                boolean[] block = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int num = board[rowStart + i][colStart + j];
                        if (num == 0 || block[num]) return false;
                        block[num] = true;
                    }
                }
            }
        }
        return true;
    }

    private static class Move {
        int row, col;
        String prevValue;
        Move(int row, int col, String prevValue) {
            this.row = row;
            this.col = col;
            this.prevValue = prevValue;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Sudoku::new);
    }
}
