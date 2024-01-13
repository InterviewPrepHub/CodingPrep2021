package String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
time complexity -> n * n!
 */
public class Permutation {

    public static void main(String[] args) {
        String s = "ABC";
//        permutate(s);

//        int[] arr = {1,2,3};
//        ArrayList<int[]> list = new ArrayList<>();
//        permute(arr, 0, list);
        permute(s,0,s.length()-1);
    }


    private static void permute(String s, int left, int right) {
        if(left==right) {
            System.out.println(s);  //ABC, ACB,
            return;
        }

        for(int i=left;i<=right;i++) {
            //do
            s = swap(s, left, i); //swap only 1st char [ABC], [ACB]
            // recur
            permute(s, left+1, right);  //(ABC, 1, 2), (ABC, 2, 2)
            //undo
            s = swap(s, left, i);
        }
    }

    private static String swap(String s, int i, int j) {
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        return String.valueOf(c);
    }

    private static void permutate(String s) {
        String prefix = "";
        permutationRec(prefix,s,new ArrayList<String>());
    }

    private static void permutationRec(String prefix, String suffix, ArrayList<String> res) {
        if(suffix.length() ==0) {
            res.add(prefix);
            System.out.println(prefix);
        } else {
            for (int i=0;i<suffix.length();i++) {
                permutationRec(prefix + suffix.charAt(i), suffix.substring(0,i) + suffix.substring(i+1, suffix.length()), res);
            }
        }
    }

    /*private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }*/

//    {1,2,3}
//    start = 0
    private static void permute(int[] arr, int start, ArrayList<int[]> result) {
        if (start >= arr.length) {
            result.add(arr.clone());    //{1,2,3}
        }
        else {
            for (int i=start;i<arr.length;i++) {
                swap(arr, start, i);
                permute(arr, start+1, result);
                swap(arr, start, i);
            }
        }
    }

    public static void swap(int[] a, int i, int j) {

        int temp = a[i] ;
        a[i] = a[j];
        a[j] = temp;
    }

}
