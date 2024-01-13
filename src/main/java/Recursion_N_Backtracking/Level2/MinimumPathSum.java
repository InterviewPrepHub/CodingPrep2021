package Recursion_N_Backtracking.Level2;

import java.util.Arrays;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(m.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] T = new int[m][n];

        for (int[] t : T) {
            Arrays.fill(t,0);
        }

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i==0 && j==0) {
                    T[i][j] = grid[i][j];
                }
                else if(i==0 && j>0) {
                    T[i][j] = T[i][j-1] + grid[i][j];
                }
                else if(j==0 && i>0) {
                    T[i][j] = T[i-1][j] + grid[i][j];
                }
                else {
                    T[i][j] = grid[i][j]+Math.min(T[i-1][j],T[i][j-1]);
                }
            }
        }

        return T[m-1][n-1];
    }
}
