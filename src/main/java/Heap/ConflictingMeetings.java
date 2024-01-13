package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


//for comparable & comparator -> https://www.techiedelight.com/sort-array-of-objects-java/

public class ConflictingMeetings {

    public static void main(String[] args) {

        Interval[] interval = {new Interval(0,30), new Interval(15,20), new Interval(5,10)};

        if (interval == null || interval.length == 0 ) {
            return;
        }

        Arrays.sort(interval, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

//        interval -> (0,30), (5,10), (15,20)
//        interval -> (0,30), (35,40), (15,20)
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end-b.end);
        minHeap.add(interval[0]);

        for (int i=1;i<interval.length;i++) {
            Interval currMeeting = interval[i]; //(5,10)  (35,40)
            Interval earlierMeeting = minHeap.poll();   //(0,30)
            if (currMeeting.start >= earlierMeeting.end) {  //no conflict
                earlierMeeting.end = currMeeting.end;
            } else {
                minHeap.add(currMeeting);    //we have conflict so add the current meeting in heap
            }
            minHeap.add(earlierMeeting);    //since we polled from min heap, we need to add it back
        }

        System.out.println(minHeap.size());
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}