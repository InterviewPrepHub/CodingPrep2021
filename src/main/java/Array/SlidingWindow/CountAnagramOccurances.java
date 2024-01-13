package Array.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramOccurances {

    public static void main(String[] args) {

        String text = "forxxorfxdofr";
        String word = "for";

        countAnagrams(text, word);
    }

    private static void countAnagrams(String text, String word) {

        int n = text.length();
        int k = word.length();

        Map<Character, Integer> word_map = new HashMap<>();
        Map<Character, Integer> text_map = new HashMap<>();
        int windowStart=0;
        int count = 0;

        for (int i=0;i<k;i++) {
            char c1 = word.charAt(i);
            word_map.put(c1, word_map.getOrDefault(c1,0)+1);
        }

        for (int windowEnd=0;windowEnd<n;windowEnd++) {
            char c2 = text.charAt(windowEnd);
            text_map.put(c2, text_map.getOrDefault(c2, 0)+1);

            if (windowEnd-windowStart+1==k) {
                if(isAnagram(text_map, word_map)) {
                    count++;
                }

                char c3 = text.charAt(windowStart);
                text_map.put(c3, text_map.get(c3)-1);
                windowStart++;
            }
        }

        System.out.println(count);
    }

    private static boolean isAnagram(Map<Character, Integer> text_map, Map<Character, Integer> word_map) {
        for (char c : word_map.keySet()) {
            if (text_map.get(c) != word_map.get(c)) {
                return false;
            }
        }
        return true;
    }
}
