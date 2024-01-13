package Recursion_N_Backtracking.Level1;

public class PowerOfX {

    public static void main(String[] args) {

        PowerOfX p = new PowerOfX();
        int res = p.power(2,5);
        System.out.println(res);
    }

    private int power(int x, int n) {
        if (n==0) {
            return 1;
        }
        int xm = power(x,n-1);
        int xm1 = x * xm;
        return xm1;
    }
}
