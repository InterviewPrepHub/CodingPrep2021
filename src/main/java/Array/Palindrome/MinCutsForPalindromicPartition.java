package Array.Palindrome;

public class MinCutsForPalindromicPartition {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String s = "abcbm";
        int count = 0;

        minCuts(s,"", count);
        System.out.println(min);
    }

    private static void minCuts(String s, String asf, int count) {

        if(s.isEmpty()) {
            System.out.println(asf);
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            String prefix = s.substring(0,i+1);
            String ros = s.substring(i+1);

            if(isPalin(prefix)) {
                minCuts(ros, asf+"("+prefix+")", count+1);
            }
        }
    }

    private static boolean isPalin(String prefix) {

        int i = 0, j = prefix.length()-1;

        while (i<=j) {
            if (prefix.charAt(i) != prefix.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
