package leetCode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/number-of-closed-islands/
 * Given a 2D grid consists of 0s (land) and 1s (water).  
 * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.
https://assets.leetcode.com/uploads/2019/10/31/sample_3_1610.png
 */
public class numberOfCLosedIslands {
    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
        // System.out.println("No of closed islands using recursions : " +
        // noOfClosedIslands(grid));
        System.out.println("Filling with better solution : " + closedIslandsBetterSolution(grid));
    }

    private static int closedIslandsBetterSolution(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i * j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 0) {
                    betterReccursive(grid, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    betterReccursive(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void betterReccursive(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 0) {
            return;
        }

        grid[i][j] = 1;
        int[] dx4 = { 1, -1, 0, 0 };
        int[] dy4 = { 0, 0, 1, -1 };

        for (int k = 0; k < 4; k++) {
            int nx4 = i + dx4[k];
            int ny4 = j + dy4[k];
            betterReccursive(grid, nx4, ny4);
        }

    }

    private static int noOfClosedIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        System.out.println("Filling the outside with water and printing the matrix");
        // filling verticalls outside water

        for (int i = 0; i < m; i++) {
            recursiveFill(grid, i, 0);
            recursiveFill(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            recursiveFill(grid, 0, j);
            recursiveFill(grid, m - 1, j);
        }

        printGrid(grid);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    recursiveFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    private static void recursiveFill(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;
        recursiveFill(grid, i + 1, j);
        recursiveFill(grid, i - 1, j);
        recursiveFill(grid, i, j - 1);
        recursiveFill(grid, i, j + 1);

    }

    private static void printGrid(int[][] grid) {
        for (int[] gridItem : grid) {
            System.out.println(Arrays.toString(gridItem));
        }
    }
}
