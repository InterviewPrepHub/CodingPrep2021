package Array.TwoPointers;

public class Longest1sAfterFlipKTimes {

    public static void main(String[] args) {
        int[] a = {1,1,0,0,1,1,1,0,1,1};
        int k = 1;

        Longest1sAfterFlipKTimes l = new Longest1sAfterFlipKTimes();
        System.out.println(l.findLongestStreakOf1s(a,k));
    }

    private static int findLongestStreakOf1s(int[] a, int k) {
        int n = a.length;
        int runningLen = 0;
        int tempK = k;
        int start = 0;
        int max_len = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {

            if(a[i] == 1) {
                runningLen++;
            } else if (tempK > 0 && tempK < k) {
                tempK--;
                runningLen++;
            } else if(tempK == k) { //k=1
                tempK--;    //0
                runningLen++;   //3
                start = i;  //start = 2
            } else { //tempk == 0
                tempK = k;
                max_len = Math.max(max_len, runningLen);
                runningLen = 0;
                int tmp  = i;   //3
                i = start;  // 2
                start = tmp;    // 3
            }
        }
        return Math.max(max_len, runningLen);
    }
}
