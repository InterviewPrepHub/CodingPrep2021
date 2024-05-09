package Array.Palindrome;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindromeI {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("race a car"));

        String str = "A man, a plan, a canal: Panama";
        // String str = "race a car";
        // String str = "amma";
        System.out.println(isPalindrome1(str));
    }

    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        // Lowercase string
        str = str.toLowerCase();

        // Compares character until they are equal
        while (start <= end) {

            char getAtStart = str.charAt(start);
            char getAtEnd = str.charAt(end);

            // If there is another symbol in left of sentence
            if (!(getAtStart >= 'a' && getAtStart <= 'z'))
                start++;

            // If there is another symbol in right of sentence
            else if (!(getAtEnd >= 'a' && getAtEnd <= 'z'))
                end--;

                // If characters are equal
            else if (getAtStart == getAtEnd) {
                start++;
                end--;
            }

            // If characters are not equal then
            // sentence is not palindrome
            else
                return false;
        }

        // Returns true if sentence is palindrome
        return true;
    }

    public static boolean isPalindrome1(String str) {

        String s = str.toLowerCase();
        int i = 0, j = s.length()-1;
        while(i<=j) {
            while (i<=j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i<=j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
