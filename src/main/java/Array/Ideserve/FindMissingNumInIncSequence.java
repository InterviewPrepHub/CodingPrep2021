package Array.Ideserve;

/**
 * Find the missing number in the increasing sequence.
 */
public class FindMissingNumInIncSequence {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8};
        findMissingNum(arr);
    }

    private static void findMissingNum(int[] arr) {

        int low = 0;
        int high = arr.length-1;

        while (low<=high) {
            int mid = (high-low)/2 + low;

            if(low==high) {
                System.out.println(low);
                break;
            } else if (arr[mid] != mid+1) {
                //mid is incorrectly placed that search in low to mid
                high = mid;
            } else {
                low = mid+1;
            }
        }
    }
}
