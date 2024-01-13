package Graph.Level2;

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from
the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the
same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected
by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.


 */
public class FloodFill {

    /*
                1,1,1           2,2,2
                1,1,0   ----->  2,2,0
                1,0,1           2,0,1
    */

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        floodFillSolu(image, 1, 1, 2);

        for (int i=0;i<image.length;i++) {
            for (int j=0;j<image[0].length;j++) {
                System.out.println(image[i][j]);
            }
        }
    }

    public static int[][] floodFillSolu(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        flood(image, image[sr][sc], newColor, sr, sc);

        return image;
    }

    public static void flood(int[][] image, int color, int newColor, int sr, int sc) {
        if (sr < 0 || sc < 0 ||  sr >= image.length || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }

        image[sr][sc] = newColor;

        flood(image, color, newColor, sr-1, sc );
        flood(image, color, newColor, sr+1, sc );
        flood(image, color, newColor, sr, sc-1 );
        flood(image, color, newColor, sr, sc+1 );
    }

}


















