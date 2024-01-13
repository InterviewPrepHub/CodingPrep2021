package Array;

import java.util.*;

/*
Given string str, the task is to find the minimum count of characters that need to be deleted from the string such
that the frequency of each character of the string is unique.

Examples:

Input: str = “ceabaacb”
Output: 2
Explanation:
The frequencies of each distinct character are as follows:
c —> 2
e —> 1
a —> 3
b —> 2
Possible ways to make frequency of each character unique by minimum number of moves are:

Removing both occurrences of ‘c’ modifies str to “eabaab”
Removing an occurrence of ‘c’ and ‘e’ modifies str to “abaacb”
Therefore, the minimum removals required is 2.

Input: S = “abbbcccd”
Output: 2
 */

public class MinimumDeletions {

    static Map<Character, Integer> map = new HashMap<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(y,x));

    //stote min count of char required to be deleted
    //to make each character uniqueue
    static int cntChar = 0;

    public static int minDel(String s) {
        map.put(s.charAt(0), 1);
        for(int i=1;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                int k = map.get(s.charAt(i));
                map.put(s.charAt(i), k+1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("key : "+entry.getKey()+" value : "+entry.getValue());
            pq.add(entry.getValue());
        }

        System.out.println(pq);

        while (!pq.isEmpty()) {
            int frequency = pq.peek();
            pq.remove();

            if (pq.isEmpty()) {
                return cntChar;
            }

            if (frequency == pq.peek()) {
                if (frequency > 1) {
                    pq.add(frequency-1);
                }
                //update cntChar
                cntChar++;
            }
        }
        return cntChar;
    }

    public static void main(String[] args) {
        int res = minDel("ceabaacb");
        System.out.println("min deletion : "+res);
    }
}
