package Heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FistNonRepeatingCharacterInStream {

    public static void main(String[] args) {
        String res = nonRepeatingChar("abadbc");
        System.out.println(res);
    }

    private static String nonRepeatingChar(String s) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            q.add(c);
            map.put(c, map.getOrDefault(c,0)+1);

            while (!q.isEmpty()) {
                if (map.containsKey(c) && map.get(q.peek()) > 1) {
                    q.poll();
                } else {
                    break;
                }
            }

            if (q.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(q.peek());
            }
        }

        return sb.toString();
    }


}
