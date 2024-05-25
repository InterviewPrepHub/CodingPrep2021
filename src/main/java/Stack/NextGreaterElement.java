package Stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void nextGreaterElement(int[] arr) {
        for(int i=0;i<arr.length;i++) { //1
            for(int j=i+1;j<arr.length;j++) {//3
                if (arr[i] < arr[j]) {
                    System.out.println(arr[i] + " -> "+ arr[j]);
                    break;
                } else if (arr[i] > arr[j]) {
                    if (j == arr.length - 1) {
                        System.out.println(arr[i] +" -> "+"-1");
                    }
                }

            }
            if (i==arr.length-1) {
                System.out.println(arr[i] +" -> "+"-1");
            }
        }


        /*Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<arr.length;i++) {
            while(!s.isEmpty()) {
                if(arr[i]>s.peek()) {
                    System.out.println(s.pop() +":"+arr[i]);
                } else {
                    break;
                }
            }
            s.push(arr[i]);
        }

        while(!s.isEmpty()) {
            System.out.println(s.pop() +":-1");
        }*/
    }

    public static void main(String[] args) {
        NextGreaterElement n = new NextGreaterElement();
        int[] arr = {8,3,5,4};
        n.nextGreaterElement(arr);
    }
}
