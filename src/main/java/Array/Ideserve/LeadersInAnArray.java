package Array.Ideserve;

/**
 * Given an array of integers, print the leaders in the array.
 * A leader is an element which is larger than all the elements in the array to its right.
 */
public class LeadersInAnArray {

    public static void main(String[] args) {
        int[] arr = {98,23,54,12,20,7,27};

        int n = arr.length;
        int currentLeader = arr[n-1];
        System.out.println(currentLeader);
        for (int i=n-1;i>=0;i--) {

            if(currentLeader < arr[i] && i>=0) {
                currentLeader = arr[i];
                System.out.println(currentLeader);
            }
        }
    }
}
