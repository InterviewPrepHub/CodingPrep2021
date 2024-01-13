package Array;

public class Sort0s1s2s {

    public static void main(String[] args) {
//        int[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int[] a= {0, 0, 0, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = a.length;

        Sort0s1s2s s = new Sort0s1s2s();
        int[] res = s.sort(a,n);

        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }

    private int[] sort(int[] a, int n) {

        int low = 0;
        int high = n-1;
        int mid = 0;

        while(mid<=high) {
            if(a[mid] == 0){
                swap(a,low,mid);
                low++;
                mid++;
            } else if(a[mid]==2) {
                swap(a,mid,high);
                high--;
            } else {
                mid++;
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
