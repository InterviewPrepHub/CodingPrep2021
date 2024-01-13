package String;

public class LongestPrefixSuffix {

    static int lps(String s) {
        int i=0;
        int n = s.length();
        int mid = (n+1)/2;
        while (mid<n) {
            if (s.charAt(mid) == s.charAt(i)) {
                mid++;
                i++;
                System.out.println(s.charAt(i));
            }
            else {
                mid = mid-i+1;
                i=0;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        String str = "abcaabc";
        int s = lps(str);
        System.out.println("lps : "+s);
    }
}
