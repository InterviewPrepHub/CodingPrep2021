package Intervals;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        merge(intervals);
    }

    private static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> output = new ArrayList<>();

        int[] curr_interval = intervals[0]; //[1,3]
        output.add(curr_interval);

        for (int[] i:intervals) {
            int curr_begin = curr_interval[0];
            int curr_end = curr_interval[1];

            int next_begin = i[0];
            int next_end = i[1];

            if(curr_end >= next_begin) {
                curr_interval[1] = Math.max(curr_end, next_end);
            } else {
                curr_interval = i;
                output.add(curr_interval);
            }
        }

        return output.toArray(new int[output.size()][intervals[0].length]);
    }
}

// output : [1,3]