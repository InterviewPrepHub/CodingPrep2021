package String;

public class MinInsertionPalindrome {

    public static void main(String[] args) {
        String str = "abc";
        char[] s = str.toCharArray();
        int res = getMinimumInsertion(s, 0, s.length - 1);
        System.out.println("res : "+res);
    }

    private static int getMinimumInsertion(char[] s, int start, int end) {

//                   abc            a b c b a
//              1  /    \  1
//               ab     bc
//            1  /      /  1
//              a  b    b  c
        //base cases
        if (start>end) return Integer.MAX_VALUE;
        if (start == end) return 0;
        if (start == end-1) return (s[start] == s[end]) ? 0 : 1;

        return (s[start] == s[end]) ? getMinimumInsertion(s, start + 1, end - 1):
                (Math.min(getMinimumInsertion(s, start, end - 1),
                        getMinimumInsertion(s, start + 1, end)) + 1);

    }
}
