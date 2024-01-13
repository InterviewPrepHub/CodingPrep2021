package Array;

/*
Given a non-negative number represented as a list of digits, add 1 to the number
(increment the number represented by the digits). The digits are stored such that
the most significant digit is first element of array.

case1 ->
    arr = {1,2,3}
    output = {1,2,4}

case2 ->
    arr = {1,2,9}
    output = {1,3,0}

case3 ->
    arr = {9,9,9}
    output = {1,0,0,0}
*/



public class Plus1 {

    private static int[] addOneToArr(int[] arr) {
        int len = arr.length-1; //2

        while (len>=0) {
            if(arr[len] != 9) {  //case1 -> if array element is less than 9, then simply add 1 to this.
                arr[len] += 1;
                return arr;
            }
            arr[len] = 0;   //case2 -> if array element is greater than 9, replace it with 0 and decrement i
            len--;
        }
        //for case 3 create a new arr
        int[] arr1 = new int[arr.length+1];
        arr1[0] = 1;
        return arr1;

    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        int[] res = addOneToArr(arr);
        for (int i=0;i< res.length;i++) {
            System.out.println(res[i]);
        }

    }

}
