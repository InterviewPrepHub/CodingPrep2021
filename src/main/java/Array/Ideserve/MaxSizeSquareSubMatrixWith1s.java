package Array.Ideserve;

/** Given a matrix of dimensions mxn having all entries as 1 or 0,
 * find out the size of maximum size square sub-matrix with all 1s.
 */
public class MaxSizeSquareSubMatrixWith1s {

    public static void main(String[] args) {

        int grid[][] = {
                { 1, 1, 0, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1 }
        };

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        int ans = Integer.MIN_VALUE;

        for (int i=dp.length-1;i>=0;i--) {
            for (int j=dp[0].length-1;j>=0;j--) {
                if (i == dp.length-1 && j == dp[0].length-1) {
                    dp[i][j] = grid[i][j];
                } else if (i == dp.length-1) {
                    dp[i][j] = grid[i][j];
                } else if (j == dp[0].length-1) {
                    dp[i][j] = grid[i][j];
                } else {
                    if (grid[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        int min = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                        dp[i][j] = min+1;

                        if (dp[i][j] > ans) {
                            ans = dp[i][j];
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
