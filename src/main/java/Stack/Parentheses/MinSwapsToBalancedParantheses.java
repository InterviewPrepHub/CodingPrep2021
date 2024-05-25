package Stack.Parentheses;

/*
You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.

Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:

Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".
Example 3:

Input: s = "[]"
Output: 0
Explanation: The string is already balanced.
 */
public class MinSwapsToBalancedParantheses {

    public int minSwaps(String s) {
        int imbalance = 0;  //maintain a balance counter - '[' inc balance & ']' dec balance
        int maxImbalace = 0;

        for (int i = 0; i < s.length(); i++) {

            //track the balance
            if(s.charAt(i) == '[') {
                imbalance++;
            } else {
                imbalance--;
            }

            //if at any point balance becomes negative, then we have more ']' than '['
            //this imbalance leads to swap
            if(imbalance < 0) {
                maxImbalace = Math.max(maxImbalace, -imbalance);
            }
        }
        return (maxImbalace+1)/2;
    }

    public static void main(String[] args) {
        String s = "]]][[[";
        MinSwapsToBalancedParantheses m = new MinSwapsToBalancedParantheses();
        System.out.println(m.minSwaps(s));
    }
}
