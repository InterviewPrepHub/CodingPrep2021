package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Please implement encode and decode
 *
 * Contact me on wechat to get Amazon、Google requent Interview questions . (wechat id : jiuzhang0607)
 *
 *
 * Example
 * Example1
 *
 * Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 * Example2
 *
 * Input: ["we", "say", ":", "yes"]
 * Output: ["we", "say", ":", "yes"]
 * Explanation:
 * One possible encode method is: "we:;say:;:::;yes"
 */
public class EncodeAndDecodeStrings {

    public static void main(String[] args) {

        EncodeAndDecodeStrings e = new EncodeAndDecodeStrings();

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        String encodeStr = e.encode(list);
        System.out.println(encodeStr);

        List<String> list1 = e.decode(encodeStr);
        System.out.println(list1);

    }

    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
//        input = ["Hello","World"]
//        decode_input = 5#Hello5#World
        String res = "";
        for(String s : strs) {
            int len = s.length();
            res += len + "#" + s;
        }
        return res;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i=0;i<str.length();i++) {
            int len = Integer.parseInt(Character.toString(str.charAt(i))); //5
            if(str.charAt(i+1) == '#') {
                start =i+2;
                end = start+len-1;

                String curr_str = createString(str,start,end);
                list.add(curr_str);
                i=start+len-1;
            }
        }
        return list;
    }

    private String createString(String s,int start, int end) {

        String ans = "";
        for (int i=start;i<=end;i++) {
            ans+=s.charAt(i);
        }
        return ans;
    }
}
