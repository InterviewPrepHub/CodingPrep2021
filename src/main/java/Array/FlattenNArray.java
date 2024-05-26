package Array;

import java.util.ArrayList;
import java.util.List;

/*
Flatten N-Dimensional Array to 1D Array:

You are given an N-dimensional array (a nested list) and your task is to convert it into a 1D array.
The N-dimensional array can have any number of nested lists and each nested list can contain any number of elements.
The elements in the nested lists are integers. Write a function that takes an N-dimensional array as input and returns a 1D array.

Example 1:

Input:
array = [1, [2, 3], [4, [5, 6]], 7]

Output:
flatten_array(array) -> [1, 2, 3, 4, 5, 6, 7]

 */
public class FlattenNArray {

    public void flattenArray(Object[] arr) {

        List<Integer> list = new ArrayList<>();

        flattenArrayHelper(arr, list);
        System.out.print("[");
        for (Integer i : list) {
            System.out.print(i+" ");
        }
        System.out.print("]");
    }

    private void flattenArrayHelper(Object[] arr, List<Integer> list) {
        for(Object obj : arr) {
            if(obj instanceof Integer) {
                list.add((Integer) obj);
            } else {
                flattenArrayHelper((Object[]) obj, list);
            }
        }
    }

    public static void main(String[] args) {

        FlattenNArray f = new FlattenNArray();

        Object[] array = {1, new Object[]{2, 3}, new Object[]{4, new Object[]{5, 6}}, 7};

        f.flattenArray(array);
    }
}
