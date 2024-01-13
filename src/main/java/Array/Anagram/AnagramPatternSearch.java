package Array.Anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings 'pattern' and 'text', find whether any anagram of string pattern is a substring of text.
 *
 * Example:
 * Input:
 * text = ideserve
 * pattern = veer
 * Output:
 * true
 * Substring which is an anagram of pattern: erve (ideserve)
 */
public class AnagramPatternSearch {

    public static void main(String[] args) {
        String str = "";
        String pat = "";
        System.out.println(isValidAnagram("veer", "even"));

        patternSearch(str, pat);
    }

    private static void patternSearch(String str, String pat) {

        int k = pat.length();

        Map<Character, Integer> pat_map = new HashMap<>();
        for (int i=0;i<pat.length();i++) {
            char ch = pat.charAt(i);
            pat_map.put(ch, pat_map.getOrDefault(ch,0)+1);
        }

        Map<Character, Integer> str_map = new HashMap<>();
        int windowStart = 0;
        for (int windowEnd=0;windowEnd<pat.length();windowEnd++) {
            char ch = str.charAt(windowEnd);
            str_map.put(ch, str_map.getOrDefault(ch, 0)+1);

            if (windowEnd-windowStart+1==k) {
                if (!isAnagram(pat_map, str_map)) {
                    char c = str.charAt(windowStart);
                    str_map.put(c, str_map.get(c)-1);
                    if (str_map.get(c) == 0) {
                        str_map.remove(c);
                    }
                    windowStart++;
                }
                break;
            }

        }

    }

    private static boolean isAnagram(Map<Character, Integer> pat_map, Map<Character, Integer> str_map) {
        for (Character ch : str_map.keySet()) {
            if (pat_map.size()==str_map.size() && !pat_map.containsKey(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidAnagram(String s1, String s2) {

        int[] res = new int[26];

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i=0;i<s1.length();i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);

            res[char1-'a']++;
            res[char2-'a']--;
        }

        for (int i=0;i<res.length;i++) {
            if (res[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
