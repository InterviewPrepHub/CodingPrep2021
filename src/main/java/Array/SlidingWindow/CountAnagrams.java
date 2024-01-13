package Array.SlidingWindow;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/*
Given a word and a text, return the count of occurrences of the anagrams of the word in the text.

An anagram of a word is a word that’s formed by rearranging the letters of the original word. For example: the anagrams of the word for are

for
fro
ofr
orf
rof
rfo
Note that, the anagrams use all the original letters exactly once.

Examples 1

Input: text =  xxorfxdofr, word = for
Output : 3
Explanation : Anagrams of the word for - for, orf, ofr appear in the text and hence the count is 3.
Example 2

Input : text = aabaabaa, word = aaba
Output : 4
Explanation : Anagrams of the word aaba - aaba, abaa each appear twice in the text and hence the
count is 4.

 */
public class CountAnagrams {

    // Two words are anagrams of each other if the count of every character in both the words are same.
    public static boolean isAnagram(Map<Character, Integer> wordCount1, Map<Character, Integer> wordCount2) {
        for (char c : wordCount1.keySet()) {
            if (wordCount1.get(c) != (wordCount2.get(c))) {
                return false;
            }
        }
        return true;
    }

    public static int countAnangramOccurances(String text, String word) {

        int n = text.length();
        int k = word.length();
        int count = 0;

        Map<Character, Integer> wordCharCount = new HashMap<>();
        for (int i=0;i<k;i++) {
            char c = word.charAt(i);
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0)+1);
        }
        System.out.println(wordCharCount);

        //find substring starting from i with length equal to length of word
        for(int i=0;i<n-k;i++) {
            Map<Character, Integer> subStringCharCount = new HashMap<>();
            for (int j=i;j<i+k;j++) {
                char c = text.charAt(j);
                subStringCharCount.put(c, subStringCharCount.getOrDefault(c, 0)+1);
            }
            //check if current substring is an anagram of given word
            if (isAnagram(wordCharCount, subStringCharCount)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int res = countAnangramOccurances("aabaabaa","aaba");
//        System.out.println(res);


        int res1 = countAnagaramsSlidingWindow("aabaabaa","aaba");
        System.out.println(res1);
    }

    private static int countAnagaramsSlidingWindow(String word, String text) {
        int n = text.length();
        int k = word.length();
        int count = 0;

        Map<Character, Integer> wordCount = new HashMap<>();
        for (int i=0;i<k;i++) {
            char c = word.charAt(i);
            wordCount.put(c, wordCount.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> substringCount = new HashMap<>();
        int start = 0;
        for (int end=0;end<n;end++) {
            char ch = text.charAt(end);
            substringCount.put(ch, substringCount.getOrDefault(ch, 0)+1);

            if(end-start+1 == k) { // We've hit the window size. Calculate result and Slide the window
                if(isAnagram(wordCount, substringCount)) {
                    count++;
                }

                // Reduce count for the char at windowStart since we are sliding the window now
                substringCount.put(text.charAt(start), substringCount.get(text.charAt(start)) - 1);
                start++; // Slide the window ahead
            }
        }
        return count;
    }
}
