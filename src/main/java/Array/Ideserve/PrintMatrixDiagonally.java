package Array.Ideserve;

/**
 * Given a matrix of mxn dimensions, print the elements of the matrix in diagonal order.
 */
public class PrintMatrixDiagonally {

    public static void main(String[] args) {

        int[][] grid = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };

        printDiagonally(grid);

    }
    private static void printDiagonally(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int k=0;k<=m-1;k++) {
            int i=k;
            int j=0;
            while(i>=0) {
                System.out.print(grid[i][j] + " ");
                i=i-1;
                j=j+1;
            }
            System.out.println();
        }

        for (int k=1;k<=n-1;k++) {
            int i=n-1;
            int j=k;
            while(j<=n-1) {
                System.out.print(grid[i][j]+" ");
                i=i-1;
                j=j+1;
            }
            System.out.println();
        }
    }
}
