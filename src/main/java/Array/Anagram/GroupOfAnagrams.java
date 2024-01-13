package Array.Anagram;

import java.util.*;

public class GroupOfAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs==null || strs.length==0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            //instead of sorting create a key string
            char[] c = new char[26];
            for (char ch : str.toCharArray()) {
                c[ch-'a']++;
            }
            String keyStr = String.valueOf(c);

            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }

        return new ArrayList<>(map.values());

//        if (strs == null || strs.length == 0) return new ArrayList<>();
//        Map<String, List<String>> map = new HashMap<>();
//        for (String s : strs) {
//            char[] ca = new char[26];
//            for (char c : s.toCharArray()) ca[c - 'a']++;
//            String keyStr = String.valueOf(ca);
//            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
//            map.get(keyStr).add(s);
//        }
//        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {

        List<List<String>> res = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(res);
    }

    public static boolean isAnagram(String str1, String str2) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        if(str1.length() != str2.length()) {
            return false;
        }

        for(int i=0;i<str1.length();i++) {
            char ch = str1.charAt(i);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
        }

        //search element in map & reduce count
        for(int i=0;i<str2.length();i++) {
            char ch2 = str2.charAt(i);

            if(map.containsKey(ch2)) {
                map.put(ch2, map.get(ch2)-1);
            } else {
                map.put(ch2, map.getOrDefault(ch2,0)+1);
            }
        }

    /*
    t = 1,  e = 0
    e = 1,  a = 0
    a = 1,  t = 0
    */

        Set<Character> keys = map.keySet();

        for(Character c : keys) {
            if(map.get(c) !=0) {
                return false;
            }
        }

        return true;

    }
}
