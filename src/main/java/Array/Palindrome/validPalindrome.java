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
public class validPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("rac a car"));
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
}
