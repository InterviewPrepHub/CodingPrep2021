package Array.Ideserve;

/**
 * Given an array of size n, find the element which occurs more than n/2 times. This element is called Majority Element.
 *
 * For example:
 * Array 1: {2 6 2 2 6 2 2 8 2 1}
 * Majority Element: 2
 * Array 2: {1 7 8 2 6 8 1 3 2 8}
 * Majority Element: none
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2,6,2,2,6,2,2,8,2,1};

        System.out.println(getMajorityElement(arr));
    }

    private static int getMajorityElement(int[] arr) {

        int count = 0;
        int candidate = 0;
        for (int i=1;i< arr.length;i++) {
            if (count==0) {
                candidate = arr[i];
                count++;
            } else {
                if (candidate == arr[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        System.out.println(candidate+" "+count);

        if (count==0) {
            System.out.println("no majority element");
        } else {
            count=0;
            for (int i=0;i<arr.length;i++) {

                if (candidate==arr[i]) {
                    count++;
                }
            }

            System.out.println(candidate+" "+count);
        }
        int n = arr.length;

        return count > n/2 ? candidate : -1;
    }
}
