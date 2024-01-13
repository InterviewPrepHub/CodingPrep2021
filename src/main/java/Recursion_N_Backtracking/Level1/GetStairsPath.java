package Recursion_N_Backtracking.Level1;

import java.util.ArrayList;

public class GetStairsPath {

    public static void main(String[] args) {
        GetStairsPath g = new GetStairsPath();
        int n = 4;
        ArrayList<String> res = g.getPaths(n);

        for (String r : res) {
            System.out.println(r);
        }
    }

    private ArrayList<String> getPaths(int n) {

        if (n==0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        if (n<0) {
            ArrayList<String> res = new ArrayList<>();
            return res;
        }

        ArrayList<String> path1 = getPaths(n-3);
        ArrayList<String> path2 = getPaths(n-2);
        ArrayList<String> path3 = getPaths(n-1);

        ArrayList<String> path = new ArrayList<>();

        for (String p1 : path1) {
            path.add("3"+p1);
        }

        for (String p2 : path2) {
            path.add("2"+p2);
        }

        for (String p3 : path3) {
            path.add("1"+p3);
        }

        return path;
    }
}
