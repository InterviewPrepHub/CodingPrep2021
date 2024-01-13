package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "aababcbb"
 * Output: 3
 * Explanation: The longest substring without repeating characters is "abc".
 */
public class LongestSubstringWORepeatChars {

    public static void main(String[] args) {

        String s = "aababcbb";
//        String s = "ccc";
        longestSubstring(s);
    }

    private static void longestSubstring(String s) {

        int windowStart = 0;
        int max_len = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd=0;windowEnd<s.length();windowEnd++) {
            char c = s.charAt(windowEnd);
            map.put(c, map.getOrDefault(c,0)+1);

            //instead of k we have windowEnd-windowStart+1
            if (map.size() < windowEnd-windowStart+1) {
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar)-1);
                if (map.get(leftChar)==0) {
                    map.remove(leftChar);
                }
                windowStart++;
            }

            if (map.size() == windowEnd-windowStart+1) {
                max_len = Math.max(max_len, windowEnd-windowStart+1);
            }
        }
        System.out.println(max_len);
    }

}
