package Graph.Level2;

import java.util.ArrayList;

public class RiverSizes {

    public static void main(String[] args) {
        int[][] map = {
//                {0, 0, 0, 1, 1},
//                {1, 1, 0, 0, 1},
//                {0, 0, 0, 1, 1},
//                {0, 0, 0, 1, 0}
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };

        ArrayList<Integer> res = solve(map);
        System.out.println(res);
    }


    private static ArrayList<Integer> solve(int[][] map){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < map.length;i++){
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 1){
                    ans.add(dfs(i, j , map));
                }
            }
        }
        return ans;
    }

    private static int dfs(int i,int j ,int[][] map){

        int[] ROW = {0,1,-1,0};
        int[] COL = {1,0,0,-1};

//        int[] ROW = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
//        int[] COL = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        if(i < 0 || j < 0 || i >= map.length || j >= map[0].length || map[i][j] == 0){
            return 0;
        }
        int count = 1;
        map[i][j] = 0;

        for (int m=0;m<ROW.length;m++) {
            int row = i+ROW[m];
            int col = j+COL[m];
            count+= dfs(row, col, map);
        }
        return count;
    }
}
