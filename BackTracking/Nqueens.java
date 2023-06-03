package BackTracking;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/n-queens/description/
 * 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
public class Nqueens {
    public static void main(String[] args) {
        int chessBoardSize = 9;
        System.out.println("N queen solution my own : \n");
        mySolution(chessBoardSize);
    }

    private static void mySolution(int n) {
        String[][] chessBoard = new String[n][n];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < n; j++)
                chessBoard[i][j] = ".";
        }
        nQueen(chessBoard, 0, n);
    }

    private static void nQueen(String[][] chessBoard, int i, int n) {
        if (i >= n) {
            for (int j = 0; j < chessBoard.length; j++) {
                System.out.println(Arrays.toString(chessBoard[j]));
            }
            return;
        }
        for (int row = 0; row < chessBoard[i].length; row++) {
            if (isSafe(chessBoard, row, i, n)) {
                chessBoard[i][row] = "Q";
                nQueen(chessBoard, i + 1, n);
                chessBoard[i][row] = ".";
            }
        }

    }

    private static boolean isSafe(String[][] chessBoard, int row, int col, int n) {
        int r = row;
        int c = col;

        // checking vertical
        while (c >= 0) {
            if (chessBoard[c][r] == "Q") {
                return false;
            }
            c--;
        }

        // left up
        r = row;
        c = col;

        while (c >= 0 && r >= 0) {
            if (chessBoard[c][r] == "Q") {
                return false;
            }
            c--;
            r--;
        }

        // right up
        r = row;
        c = col;

        while (c >= 0 && r < chessBoard[c].length) {
            if (chessBoard[c][r] == "Q") {
                return false;
            }
            c--;
            r++;
        }

        return true;
    }
}
