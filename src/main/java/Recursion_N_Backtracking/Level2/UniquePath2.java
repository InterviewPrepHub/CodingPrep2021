package Recursion_N_Backtracking.Level2;

import java.util.Arrays;

/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right
at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square
that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

 */

public class UniquePath2 {

    public static void main(String[] args) {
        UniquePath2 u = new UniquePath2();
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};

        int res = u.uniquePathsWithObstacles(grid);
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int[] d: dp) {
            Arrays.fill(d,-1);
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if(i==0 && j==0) {
                    dp[i][j] = 1;
                }
                else {
                    int up=0, left=0;
                    if (i>0) up=dp[i-1][j];
                    if (j>0) left=dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
