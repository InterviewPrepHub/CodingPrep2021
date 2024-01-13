package Array.Ideserve;

/**
 * Given two integer arrays where second array is duplicate of first array with just 1 element missing.
 * Find the element.
 *
 * Example:
 * Input:
 * 9 7 8 5 4 6 2 3 1
 * 2 3 4 9 1 8 5 6
 */
public class FindMissingNumberInDuplicateArr {

    public static void main(String[] args) {
        int[] arr1 = {9,7, 8, 5, 4, 6, 2, 3, 1};
        int[] arr2 = {2, 3, 4, 9, 1, 8, 5, 6};

        int result = 0;

        for (int i=0;i<arr1.length;i++) {
            result ^= arr1[i];
        }

        for (int i=0;i<arr2.length;i++) {
            result ^= arr2[i];
        }

        System.out.println(result);
    }
}
