package Graph.Level1;

public class CountNumberOfIslands {

    public static void main(String[] args) {

        CountNumberOfIslands c = new CountNumberOfIslands();

        char[][] islands = {{'1', '1', '0', '0', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '1', '0', '0'},
                            {'0', '0', '0', '1', '1'}};

//        System.out.println(c.noOfIsland(islands));

        c.noOfIsland(islands);
    }

    public void noOfIsland(char[][] islands) {

        if (islands.length==0 || islands == null) {
            System.out.println(0);
        }

        boolean[][] visited = new boolean[islands.length][islands[0].length];
        int count = 0;

        for (int i=0;i<islands.length;i++) {
            for (int j=0;j<islands[i].length;j++) {
                if (islands[i][j] == '1' && !visited[i][j]) {
                    drawTreeForComponent(islands, i, j, visited);
                    count++;
                }
            }
        }

        System.out.println("count : "+count);
    }

    private void drawTreeForComponent(char[][] islands, int i, int j, boolean[][] visited) {
        if (i<0 || i>=islands.length || j<0 || j>=islands[0].length || visited[i][j] == true || islands[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        drawTreeForComponent(islands, i-1, j, visited); //north
        drawTreeForComponent(islands, i, j+1, visited); //east
        drawTreeForComponent(islands, i, j-1, visited); //west
        drawTreeForComponent(islands, i+1, j, visited); //south
    }

}
