package Array;

public class Sort0s1s {

    public static void main(String[] args) {
//        int[] a = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int[] a = {0, 0, 0, 1, 0, 1 };
        Sort0s1s s = new Sort0s1s();
        int[] res = s.sort(a);

        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }

    private int[] sort(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a.length-1;

        while(mid<=high) {
            if(a[mid] == 0) {
                swap(a,low,mid);
                low++;
                mid++;
            } else if(a[mid] == 1) {
                swap(a,mid,high);
                high--;
            }
        }
        return a;
    }

    private void swap(int[] a, int low, int mid) {
        int temp = a[low];
        a[low] = a[mid];
        a[mid] = temp;
    }
}
