package Recursion_N_Backtracking.Level2;

/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums
and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.



Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
 */

public class TargetSum {

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        int target = 3;

        System.out.println(findTarget(a, target));

    }

    static int ans = 0;

    private static int findTarget(int[] a, int target) {
        int index = 0;
        int sum = 0;
        findTarget(a, index, target, sum);
        return ans;
    }

    private static void findTarget(int[] a, int i, int target, int sum) {
        if (i == a.length) {
            if (sum == target) {
                ans++;
            }
            return;
        }

        findTarget(a, i+1, target, sum+a[i]);
        findTarget(a, i+1, target, sum-a[i]);
        return;
    }
}
