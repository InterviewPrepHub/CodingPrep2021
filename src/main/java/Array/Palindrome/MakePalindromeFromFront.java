package Array.Palindrome;

/**
 * Given string str we need to tell minimum characters to be added in front of the string to make string palindrome.
 *
 * Examples:
 *
 * Input  : str = "ABC"
 * Output : 2
 * We can make above string palindrome as "CBABC"
 * by adding 'B' and 'C' at front.
 *
 * Input  : str = "AACECAAAA";
 * Output : 2
 * We can make above string palindrome as AAAACECAAAA
 * by adding two A's at front of string.
 *
 */
public class MakePalindromeFromFront {

    public static void main(String[] args) {

        MakePalindromeFromFront m = new MakePalindromeFromFront();
        String str = "ABC";
        System.out.println(m.noOfAppends(str));

    }

    private int noOfAppends(String s) {
        int count = 0;
        int flag = 0;

        while(s.length() > 0) {
            //if string is palindrome the break from loop
            if (isPalindrome(s)) {
                flag = 1;
                break;
            } else {
                count++;
                //erase last element from string
                s = s.substring(0, s.length()-1);
            }
        }
        if (flag == 1) {
            return count;
        }
        return -1;
    }

    private boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length()-1;

        while(end >= start) {

            if (str.charAt(end) != str.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
