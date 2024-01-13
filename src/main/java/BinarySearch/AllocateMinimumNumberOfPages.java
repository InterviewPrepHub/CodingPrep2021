package BinarySearch;

/*
Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages.
Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum
number of pages assigned to a student is minimum.

Good explanation : https://www.youtube.com/watch?v=2JSQIhPcHQg
 */
public class AllocateMinimumNumberOfPages {

    private static int findMinPages(int[] arr, int k) {
        int start = 0, end = 0, n = arr.length, result=-1;

        for (int i=0;i<n;i++) {
            end+=arr[i];
        }

        if (n<k) {
            return -1;
        }

        while (start<=end) {
            int mid = start + ((end-start)/2);
            if (isValid(arr,n,k,mid)) {
                //if isValid is true
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }

        }
        return result;
    }

    private static boolean isValid(int[] arr, int n, int k, int curr_min) {
        int studentsRequired = 1;
        int sum = 0;

        // iterate over all books
        for (int i = 0; i < n; i++)
        {
            // check if current number of pages are greater
            // than curr_min that means we will get the result
            // after mid no. of pages
            if (arr[i] > curr_min)
                return false;

            // count how many students are required
            // to distribute curr_min pages
            if (sum + arr[i] > curr_min)
            {
                // increment student count
                studentsRequired++;

                // update sum
                sum = arr[i];

                // if students required becomes greater
                // than given no. of students,return false
                if (studentsRequired > k)
                    return false;
            }

            // else update curr_sum
            else
                 sum += arr[i];
        }
        return true;
    }

    public static void main(String[] args) {

//        arr is no of pages in each book
//        k is no of students
//        same book cannot be given to moe than 1 student
//        student cannot not be given a book
//        single student cannot be given all books
//        continuous distribution of books

        int[] arr = {10,20,30,40};
//        int arr[] = {12, 34, 67, 90};
        int res = findMinPages(arr, 2);
        System.out.println("res : "+res);
    }
}
