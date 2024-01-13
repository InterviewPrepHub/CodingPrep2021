package String;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        String[] arr1 = {"apple", "ape", "april"};
        String res = lcp(arr1);
        System.out.println(res);
    }

    private static String lcp(String[] arr) {
        String prefix = arr[0];

        for (int i=1;i< arr.length;i++) {
            prefix = lcpUtil(prefix, arr[i]);
        }

        return  prefix;
    }

    private static String lcpUtil(String s1, String s2) {
        String result = "";
        for (int i=0, j=0;i<s1.length() && j<s2.length();i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                break;
            }
            result += s1.charAt(i);
        }
        return result;
    }


}
