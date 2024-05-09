package Array.Palindrome;

/*
https://leetcode.com/problems/valid-palindrome-ii/description/
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 */

import java.util.ArrayList;
import java.util.List;

public class ValidPalindromeII {

    public static void main(String[] args) {

        ValidPalindromeII v = new ValidPalindromeII();
        String str = "abcb";
        /*List<String> stringList = v.getNewString(str);
        boolean res = v.isValidPalin(stringList);
        System.out.println(res);*/

        System.out.println(v.isPalindrome(str));

    }


    public boolean isPalindrome(String str) {
        int i = 0, j = str.length()-1;

        while (i<=j) {
            if(str.charAt(i) != str.charAt(j)) {
                return palin(str,i+1,j) || palin(str,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean palin(String str, int i, int j) {

        while(i<=j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public List<String> getNewString(String s) {

        String remainingString;
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            char[] chArr = removeChar(s.toCharArray(), i);
            remainingString = new String(chArr);
            System.out.println(remainingString);
            list.add(remainingString);
        }

        return list;

    }

    public char[] removeChar(char[] arr, int index) {

        int n = arr.length;
        char[] ch = new char[n];
        for(int i=0;i<n;i++) {
            if(i!=index) {
                ch[i] = arr[i];
            }
        }
        return ch;
    }
}


/*
Time complexity
O(n2) -> get new string create new string by removing each character one by one and
then checks each of the strings for valid palindrome
 */