package Array;

/*
Given an array A of N elements. Find the majority element in the array.
A majority element in an array A of size N is an element that appears
more than N/2 times in the array.
*/

public class MajorityElement {

    public static void main(String[] args) {
        
        int[] arr = {1,2,2,2,2,4,3};
        Integer m_Ele = findMajorityElement(arr);
        System.out.println("majority element : "+m_Ele);
    }

    private static Integer findMajorityElement(int[] arr) {
        Integer candidate = null;
        int count = 0;

        //find the majority element
        for(int i=0;i<arr.length;i++) {
            if(count==0) {
                candidate=arr[i];
                count++;
            } else {
                if (candidate == arr[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        System.out.println("candidate : "+ candidate + " count : "+count);

        //make sure that the candidate we got is the majority element
        if (count==0) {
            return null;
        }
        count = 0;
        for(int i=0;i<arr.length;i++) {
            if (candidate==arr[i]) {
                count++;
            }
        }
        return count > arr.length/2 ? candidate : null;
    }
}
