package BinarySearch;

public class MinInSortedRotatedArray {

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        int res = findPivot(a);
        System.out.println(res);
    }

    private static int findPivot(int[] a) {
        int pivot = -1;
        if(a!=null && a.length > 0) {
            pivot = 0;
            for(int i=0;i<a.length-1;i++) {
                if(a[i] > a[i+1]) {
                    pivot = i+1;
                    break;
                }
            }
        }
        return a[pivot];
    }
}
