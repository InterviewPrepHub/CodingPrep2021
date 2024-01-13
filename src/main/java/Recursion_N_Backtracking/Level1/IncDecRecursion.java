package Recursion_N_Backtracking.Level1;

public class IncDecRecursion {

    public static void main(String[] args) {
        IncDecRecursion s = new IncDecRecursion();
        s.incDecOrder(5);
    }

    public void incDecOrder(int n) {

        decOrder(n);
        System.out.println();
        incOrder(n);
    }

    /*
    n = 5 -> 5,4,3,2,1
    n = 4 -> 4,3,2,1
    */
    public void decOrder(int n) {
        if(n==0) {
            return;
        }
        System.out.println(n);
        decOrder(n-1);
    }

    /*
    ^
    | dec order
    ---------------------
    Recursion statement
    ---------------------
    | inc order
    0
    1
    2
    3
    4
    5
     */

    /*
    n = 5 -> 1,2,3,4,5
    n = 4 -> 1,2,3,4 ------- 5
    */
    public void incOrder(int n) {
        if(n==0) {
            return;
        }
        incOrder(n-1);
        System.out.println(n);
    }
}
