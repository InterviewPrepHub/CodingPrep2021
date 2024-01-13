package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest possible substring in it that has exactly K distinct characters.
If there is no possible substring then print -1.

You can assume that K is less than or equal to the length of the given string.

Example 1:

Input: S = "aabacbebebe", K = 3
Output: 7
Explanation: "cbebebe" is the longest substring with 3 distinct characters.
 */
public class LongestSubstringWithKDistinctChars {

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        longestSubstring(s, k);
    }

    private static void longestSubstring(String str, int k) {

        int n = str.length();
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int windowLen = 0;
        int max_len = Integer.MIN_VALUE;

        for (int windowEnd=0;windowEnd<n;windowEnd++) {
            char c = str.charAt(windowEnd);
            map.put(c, map.getOrDefault(c,0)+1);

            if (map.size()==k) {
                windowLen = windowEnd-windowStart+1;
                max_len = Math.max(max_len, windowLen);
                char c1 = str.charAt(windowStart);
                map.put(c1, map.get(c1)-1);
                windowStart++;
            }
        }
        System.out.println(max_len);

    }

}
