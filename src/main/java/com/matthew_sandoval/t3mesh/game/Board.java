package com.matthew_sandoval.t3mesh.game;

public class Board {
    private final char[][] grid;
    private final int[][][] winCombos = {
            {{0,0}, {0,1}, {0,2}},
            {{1,0}, {1,1}, {1,2}},
            {{2,0}, {2,1}, {2,2}},
            {{0,0}, {1,0}, {2,0}},
            {{0,1}, {1,1}, {2,1}},
            {{0,2}, {1,2}, {2,2}},
            {{0,0}, {1,1}, {2,2}},
            {{0,2}, {1,1}, {2,0}}
    };

    public Board() {
        grid = new char[3][3];
        reset();
    }

    public void reset() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new IllegalArgumentException("Row and column must be between 1-3");
        }
        if (grid[row][col] != ' ') {
            return false;
        }
        grid[row][col] = player;
        return true;
    }

    public boolean checkWinner(char player) {
        for (int[][] combo : winCombos) {
            if (grid[combo[0][0]][combo[0][1]] == player &&
                    grid[combo[1][0]][combo[1][1]] == player &&
                    grid[combo[2][0]][combo[2][1]] == player) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + grid[row][col] + " ");
                if (col < 3 - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 3 - 1) {
                System.out.println("---+---+---");
            }
        }
    }
}