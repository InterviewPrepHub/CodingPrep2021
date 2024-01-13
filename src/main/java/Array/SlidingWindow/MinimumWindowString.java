package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, find the smallest substring of s that has all the characters of t (including duplicates).
 * If there is no such substring, then return an empty string.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The smallest substring of s that includes all the characters of t is "BANC".
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"t
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the smallest substring. Since no such substring exists, return "".
 */
public class MinimumWindowString {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        minWindowString(s, t);

    }

    private static void minWindowString(String str, String word) {

        Map<Character,Integer> str_map = new HashMap<>();
        Map<Character, Integer> word_map = new HashMap<>();
        int min_len = Integer.MAX_VALUE;

        for (int i=0;i<word.length();i++) {
            char c1 = word.charAt(i);
            word_map.put(c1, word_map.getOrDefault(c1,0)+1);
        }

        int windowStart=0;
        int min_start = 0;
        for (int windowEnd=0;windowEnd<str.length();windowEnd++) {
            char c2 = str.charAt(windowEnd);
            str_map.put(c2, str_map.getOrDefault(c2, 0)+1);

            while(containsAll(word_map, str_map)) {
                if(windowEnd-windowStart+1 < min_len) {
                    min_len = windowEnd-windowStart+1;
                    min_start = windowStart;
                }

                //move the left most char out of window
                char leftChar = str.charAt(windowStart);
                str_map.put(leftChar, str_map.get(leftChar)-1);
                if (str_map.get(leftChar) == 0) {
                    str_map.remove(leftChar);
                }
                windowStart++;
            }
        }
        String result = str.substring(min_start, min_start+min_len);
        System.out.println(result);
    }

    private static boolean containsAll(Map<Character, Integer> word_map, Map<Character, Integer> str_map) {

        for (Map.Entry<Character, Integer> entry: word_map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (!str_map.containsKey(key)) {
                return false;
            }

            if (!str_map.containsValue(val)) {
                return false;
            }
        }
        return true;
    }
}
