package Array;

/*
Given a sorted array, remove duplicates in place such that  duplicates appeared at most twice and return the new length
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        //remove duplicates when they occur twice
        int[] arr = {1,1,2,2,3};
        int res1 = removeDuplicates(arr);

        //remove duplicates when they occur atmost twice
        int[] arr1 = {1,1,1,2,2,3};
        int res2 = removeDuplicates1(arr1);
        System.out.println(res2);

        //1,1,2,2,2,3
        //index = 2,3
        //1 = 2,3

    }

    private static int removeDuplicates1(int[] arr) {
        int index = 2;
        for (int i = 2; i< arr.length; i++) {
            if (arr[i] != arr[index-2]) {
                arr[index] = arr[i];
                index++;
            }

        }
        return index;
    }

    private static int removeDuplicates(int[] arr) {
        int index = 1;
        for (int i = 0; i< arr.length-1; i++) {
            if (arr[i] != arr[i+1]) {
                arr[index] = arr[i+1];
                index++;
            }

        }

        System.out.println(index);
        return index;
    }
}
