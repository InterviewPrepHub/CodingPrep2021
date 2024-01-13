package Array.Palindrome;

public class CountPalindromicSubstrings {

    public static void main(String[] args) {
        String str = "banana";
        System.out.println(countPaliSubstring(str));
    }

    private static int countPaliSubstring(String str) {
        int n = str.length();
        boolean[][] palin = new boolean[n][n];
        int start = 0, end = 0, count = 0;

        for (int curr_len=0;curr_len<n;curr_len++) {
            for (int i=0,j=curr_len;j<n;i++,j++) {

                if (curr_len == 0) {
                    palin[i][j] = true;
                } else if (curr_len == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        palin[i][j] = true;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && palin[i+1][j-1]) {
                        palin[i][j] = true;
                    }
                }

                if (palin[i][j]){
                    start = i;
                    end = j;
                    count++;
                }
            }
        }

        String ans = "";

        for (int i=start;i<=end;i++) {
            ans+=str.charAt(i);
        }
        System.out.println(ans);

        return count;
    }
}
