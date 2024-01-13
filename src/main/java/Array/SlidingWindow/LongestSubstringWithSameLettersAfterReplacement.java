package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only. If you are allowed to replace at most k letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 *
 * Input: s="abcababb", k=2
 * Output: 5
 * Explanation: Replace the two 'a' with 'b' in the substring 'ababb' to get the longest substring "bbbbb"
 * with same letters.
 *
 * Example 2:
 *
 * Input: s="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to get the longest substring "ccc" with same letters.
 */
public class LongestSubstringWithSameLettersAfterReplacement {

    //this is a problem variant of longest substring without repeating characters

    public static void main(String[] args) {
        String s="abcababb";
        int k=2;

        int windowStart = 0;
        int max_len = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd=0;windowEnd<s.length();windowEnd++) {
            char c = s.charAt(windowEnd);
            map.put(c, map.getOrDefault(c,0)+1);

            //calculate max repeating charactern current window
            int maxRepeatLetterCount = getMaxRepeatLetterCount(map);

            //current window[windowEnd-windowStart+1] remaining character in window [maxRepeatLetterCount]
            while((windowEnd-windowStart+1) - maxRepeatLetterCount > k) {
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar)-1);
                windowStart++;
            }
            max_len = Math.max(max_len, windowEnd-windowStart+1);
        }
        System.out.println(max_len);
    }

    private static int getMaxRepeatLetterCount(Map<Character, Integer> map) {
        int max_value = Integer.MIN_VALUE;
        for (int c : map.values()) {
            max_value = Math.max(max_value, c);
        }
        return max_value;
    }
}
