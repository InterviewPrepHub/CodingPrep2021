package Sorting;

/*
1. middle point to divide => m = l + (r-1)/2
2. call mergesort for first half    =>  mergesort(arr, l, m)
3. call mergesort for second half    =>  mergesort(arr, m+1, r)
4. merge two halves => merge(arr, l, m, r)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        mergeSort(arr, 0, arr.length-1);

        for (int i=0;i< arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void merge(int Arr[], int start, int mid, int end) {

        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid+1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(i <= mid && j <= end) {
            if(Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k++; i++;
            }
            else {
                temp[k] = Arr[j];
                k++; j++;
            }
        }

        // add elements left in the first interval
        while(i <= mid) {
            temp[k] = Arr[i];
            k++; i++;
        }

        // add elements left in the second interval
        while(j <= end) {
            temp[k] = Arr[j];
            k++; j++;
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

// Arr is an array of integer type
// start and end are the starting and ending index of current interval of Arr

    static void mergeSort(int Arr[], int start, int end) {

        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid);
            mergeSort(Arr, mid+1, end);
            merge(Arr, start, mid, end);
        }
    }
}
