package Stack;

import java.util.Stack;

/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of
contiguous bars whose heights are given in an array.

Input: heights = [2,1,5,6,2,3]
Output: 10 [the bar value with 5 and 6 where 5+5 = 10 is the largest rectangular area]

Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.


At each index of the given hts array, find the left and right boundary between which the height of rectangle
is atleast equal to than current height.

 */
public class LargestRectangleInHistogram {


    /*
        here we take indices whose value in arr keeps increasing and we add it to stack
        once it dec, we pop it out from stack
        TC - O(n)
        space = O(n)
     */

    public int largestRectangleAreaUsingStack(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHt = i == n ? 0 : heights[i];

            //check if this is the last element
            //currHt > ht[top] ? push(i) : pop  & find area
            while(!stack.isEmpty() && currHt < heights[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek()-1;
                int area = heights[top] * width;
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }

        return maxArea;
    }

    /*
    heights = [2,1,5,6,2,3]
    for index = 2 , left boundary index= 1 and right boundary index= 6 since both indices has heights less than 2.
    width = 6-1-1 = 4
    area = height * width = 2 * 4 = 8
    TC - O(n)
    space = 2* O(n)
     */
    public int largestRectangleArea(int[] heights) {

         int n = heights.length;

         if(n == 0) return 0;

         int maxArea = 0;

         int[] left = new int[n];
         int[] right = new int[n];
         left[0] = -1;
         right[n-1] = n;

        for (int i = 1; i < n; i++) {
            int prev = i-1; //0
            while(prev >= 0 && heights[prev] >= heights[i]) {
                prev = left[prev];
            }
            left[i] = prev;
        }

        for (int i = n-2; i >= 0; i--) {
            int prev = i+1; //5
            while(prev < n && heights[prev] >= heights[i]) {
                prev = right[prev];
            }
            right[i] = prev;
        }


        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] -1;
            maxArea = Math.max(maxArea, heights[i]*width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        int res = l.largestRectangleArea(arr);
        System.out.println(res);

        System.out.println(l.largestRectangleAreaUsingStack(arr));
    }
}
