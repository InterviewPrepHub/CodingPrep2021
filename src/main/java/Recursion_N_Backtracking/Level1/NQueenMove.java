package Recursion_N_Backtracking.Level1;

public class NQueenMove {

    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        String psf = "";
        moveQueen(chess,psf,0);

        System.out.println(psf);
    }

    private static void moveQueen(int[][] chess, String psf, int row) {

        if(row == chess.length) {
            System.out.println(psf);
            return;
        }

        for(int col=0;col<chess[0].length;col++) {
            if(isSafeToMoveQueen(chess,row,col)) {
                chess[row][col] = 1;
                moveQueen(chess, psf+row+"-"+col+",", row+1);
                chess[row][col] = 0;
            }
        }

    }

    private static boolean isSafeToMoveQueen(int[][] chess, int row, int col) {
        for (int i=row-1, j=col;i>=0;i--) { //going up in row [check vertical]
            if(chess[i][j] == 1) {
                return false;
            }
        }

        for (int i=row-1,j=col-1;i>=0 & j>=0;i--,j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }

        for (int i=row-1,j=col+1;i>=0 & j<chess.length;i--,j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
