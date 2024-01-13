package Recursion_N_Backtracking.Level1;

import java.util.ArrayList;
import java.util.List;

public class GetSubSequence {

    public static void main(String[] args) {

        String str = "abc";
        /*System.out.println(str.substring(1));

        System.out.println(str.substring(1,3));

        CharSequence ch = str.subSequence(1, 3);*/

        getSubSeq(str,"");

        subsets(new int[]{1,2,3});
    }

    private static void getSubSeq(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        char c = s.charAt(0);   //1
        String sb = s.substring(1); //2

        getSubSeq(sb, ans+"");   //3
        getSubSeq(sb, ans+c);    //4
    }

    private static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0,arr,new ArrayList<Integer>(),subsets);
        return subsets;
    }

    private static void generateSubsets(int index, int[] arr, ArrayList<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i=index;i<arr.length;i++) {
            current.add(arr[i]);
            generateSubsets(i+1, arr, current,subsets);
            current.remove(current.size()-1);
        }
    }
}
