import java.util.Arrays;

/**
 * NumberOfEnclaves
 * https://leetcode.com/problems/number-of-enclaves/
 * 
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and
 * 1 represents a land cell.
 * 
 * A move consists of walking from one land cell to another adjacent
 * (4-directionally) land cell or walking off the boundary of the grid.
 * 
 * Return the number of land cells in grid for which we cannot walk off the
 * boundary of the grid in any number of moves.
 */
public class NumberOfEnclaves {
    static int count = 0;

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0
        } };
        // int[][] grid = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0
        // } };
        System.out.println("Number of enclaves possible : " + numberOfCaves(grid));
    }

    private static int numberOfCaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i * j == 0 || j == n - 1 || i == m - 1) && grid[i][j] == 1) {
                    floodFill(grid, i, j, m, n, flag);
                }
            }
        }
        flag = true;

        return Arrays.stream(grid).flatMapToInt(row -> Arrays.stream(row)).sum();

        // return count; cant use count due to static issues and no need of flags;
    }

    private static void floodFill(int[][] grid, int i, int j, int m, int n, Boolean flag) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        // if (flag) {
        // count++;
        // }
        floodFill(grid, i + 1, j, m, n, flag);
        floodFill(grid, i - 1, j, m, n, flag);
        floodFill(grid, i, j - 1, m, n, flag);
        floodFill(grid, i, j + 1, m, n, flag);

    }

}