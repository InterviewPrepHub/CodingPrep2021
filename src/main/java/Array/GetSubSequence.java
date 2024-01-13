package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetSubSequence {

    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> ret = getSS(s);
//        System.out.println(ret);

        String ans = "";

        int[] arr = {1,2,3};
        ArrayList<Integer> path = new ArrayList<>();

        printSubsequences(arr,0,path);

//        printSS(s, ans);

        System.out.println(set);
    }

    /*{
        {1},{2},{3},{1,2},{2,3},{3,4},{1,2,3}
    }*/
    public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {

        // Print the subsequence when reach the leaf of recursion tree
        if (index == arr.length) {

            // Condition to avoid printing empty subsequence
            if (path.size() > 0)
                System.out.println(path);
        }

        else
        {

            // Subsequence without including the element at current index
            printSubsequences(arr, index + 1, path);

            path.add(arr[index]);

            // Subsequence including the element at current index
            printSubsequences(arr, index + 1, path);

            // Backtrack to remove the recently inserted element
            path.remove(path.size() - 1);
        }
        return;
    }

    private static void printSS(String str, String ans) {   //(abc, _),(bc,_),()

        if(str.length() == 0) {
            set.add(ans);
//            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);    //a, b

        String s = str.substring(1);    //bc, c

        printSS(s, ans + "");   //_, b,
        printSS(s, ans + ch);   //
    }


    private static ArrayList<String> getSS(String str) {
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String subStr = str.substring(1);
        ArrayList<String> rres = getSS(subStr);

        ArrayList<String> mres = new ArrayList<>();
        for(String r : rres) {
            mres.add(""+r);
            mres.add(ch+r);
        }
        return mres;
    }

}
