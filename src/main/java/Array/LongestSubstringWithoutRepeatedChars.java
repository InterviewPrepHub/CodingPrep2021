package Array;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstringWithoutRepeatedChars {

    public int longestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max_len = 0;
        int j = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                j = map.get(ch)+1;
//                map.put(ch, i);
            } else {
                map.put(ch, i);
                max_len = Math.max(max_len, i-j+1);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbb";
        String s = "pwwkew";
        LongestSubstringWithoutRepeatedChars l = new LongestSubstringWithoutRepeatedChars();
        int res = l.longestSubstring(s);
        System.out.println(res);
    }
}

























