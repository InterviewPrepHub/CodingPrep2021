package Array;

/*
Given an array of positive integers. All numbers occur an even number of times except one number which occurs an
odd number of times. Find the number in O(n) time & constant space.
 */
public class GetOddOccurrences {

    //time complexity - O(n2)
    public static int getOddOccurrences1(int[] arr, int n) {

        for (int i=0;i< n;i++) {
            int count = 0;
            for (int j=0; j< n;j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count %2 != 0) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int getOddOccurrences2(int[] arr, int n) {
        int res = 0;
        for (int i=0;i< arr.length;i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{ 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
        int n = arr.length;
//        System.out.println(getOddOccurrences1(arr, n));

        System.out.println(getOddOccurrences2(arr, n));

    }
}
