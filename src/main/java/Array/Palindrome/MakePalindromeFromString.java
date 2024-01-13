package Array.Palindrome;

/**
 * Minimum number of Appends needed to make a string palindrome.
 *
 * Given a string s we need to tell minimum characters to be appended
 * (insertion at the end) to make a string palindrome.
 *
 * Examples:
 *
 * Input : s = "abede"
 * Output : 2
 * We can make string palindrome as "abedeba"
 * by adding ba at the end of the string.
 *
 * Input : s = "aabb"
 * Output : 2
 * We can make string palindrome as"aabbaa"
 * by adding aa at the end of the string.
 */
public class MakePalindromeFromString {

    /**
     * If we know the longest palindromic sub-sequence is x
     * and the length of the string is n then, what is the
     * answer to this problem?
     *
     * It is n - x as we need n - x insertions to make the remaining characters also palindrome.
     *
     */

    public int lcs(String str1, String str2, int m, int n) {
        if (m==0 || n==0) {
            return 0;
        } else if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return 1+lcs(str1, str2, m-1, n-1);
        } else {
            return Math.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
        }
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;

        if (end==1) {
            return true;
        }

        while(end >= start) {
            if (str.charAt(end) != str.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int noOfAppends(String str) {

        //if the string is already palindrome then no need to change anything
        if (isPalindrome(str)) {
            return 0;
        }

        str = str.substring(1);

        return 1+noOfAppends(str);
    }

    public static void printArray(char[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {
//        checkPalindome("aabbeeeee");
        MakePalindromeFromString m = new MakePalindromeFromString();
        String s1 = "aabb";
        String s2 = "abede";
        String s3 = "aabbeeeee";
//        int n = m.noOfAppends(s3);
//        System.out.println(n);

        //using lcs
        String rev = new StringBuilder(s3).reverse().toString();
        int x = m.lcs(s3, rev, s3.length(), rev.length());
        int n = s3.length();
        System.out.println(n-x);
    }
}
