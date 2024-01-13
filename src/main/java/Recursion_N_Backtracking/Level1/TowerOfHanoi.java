package Recursion_N_Backtracking.Level1;

public class TowerOfHanoi {

    public static void main(String[] args) {
        toh(3,"A","B","C");
    }

    private static void toh(int n, String a, String b, String c) {
        toh(n-1, a,c,b);
        System.out.println("["+n+" -> "+a+"->"+c+" by "+b);
        toh(n-1, a,c,b);
    }
}
