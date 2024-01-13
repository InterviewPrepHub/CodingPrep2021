package Matrix;

public class PrintMatrixDiagonally {

    public static void main(String[] args) {
        char[][] grid = {
                {'a','b','c','d'},  //i
                {'e','f','g','h'},  //[i-1][j-1]
                {'i','j','k','l'},
                {'m','n','o','p'}
        };

        PrintMatrixDiagonally p = new PrintMatrixDiagonally();
        p.printDiagonal(grid);
    }

    private void printDiagonal(char[][] grid) {
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
