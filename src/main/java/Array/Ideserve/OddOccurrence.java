package Array.Ideserve;

/**
 * Find the number which occurs odd number of times
 */
public class OddOccurrence {

    public static void main(String[] args) {
        int[] arr = {2,3,4,3,1,4,5,1,4,2,5};

        int res = 0;
        for (int i=0;i< arr.length;i++) {
            res = res ^ arr[i];
        }

        System.out.println(res);
    }
}
