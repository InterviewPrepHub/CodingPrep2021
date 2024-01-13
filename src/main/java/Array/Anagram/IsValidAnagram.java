package Array.Anagram;

public class IsValidAnagram {

    public static void main(String[] args) {
        String s1 = "for";
        String s2 = "rft";

        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String s1, String s2) {
        int[] res = new int[26];

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i=0;i< s1.length();i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            res[c1-'a']++;
            res[c2-'a']--;
        }

        for (int i : res) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
}
