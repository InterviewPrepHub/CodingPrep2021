package Recursion_N_Backtracking.Level2;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        NQueen q = new NQueen();
        List<List<String>> res = q.solveNQueens(4);
        System.out.println(res);

    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> allBoards = new ArrayList<>();

        helper(board, allBoards, 0);
        return allBoards;
    }

    private void helper(char[][] board, List<List<String>> allBoards, int col) {

        if(col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int row=0;row<board.length;row++) {
            if(isSafe(row,col,board)) {
                board[row][col] = 'Q';
                helper(board,allBoards,col+1);
                board[row][col] = '.';
            }
        }
    }

    private void saveBoard(char[][] board, List<List<String>> allBoards) {

        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i=0;i< board.length;i++) {
            row = "";
            for (int j=0;j< board[0].length;j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row +='.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    private boolean isSafe(int row, int col, char[][] board) {

        //check horizontal
        for (int j=0;j<board.length;j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        //check vertical
        for (int i=0;i<board[0].length;i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //check upper left [r-1][c-1]
        int r = row;
        for (int c=col;c>=0 && r>=0;c--,r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //check upper right [r-1][c+1]
        r=row;
        for (int c=col;c<board.length && r>=0;c++,r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //check lower left [r+1] [c-1]
        r=row;
        for (int c=col;c>=0 && r< board.length;c--,r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //check lower right [r+1][c+1]
        r=row;
        for (int c=col;c<board.length && r<board.length;c++,r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
