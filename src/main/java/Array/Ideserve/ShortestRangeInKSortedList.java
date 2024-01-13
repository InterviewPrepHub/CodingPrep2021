package Array.Ideserve;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given k lists of sorted integers. Find shortest range that includes one number from each of the k lists.
 *
 * Input:-
 * L1 :- { 4, 10, 15, 24, 26}
 * L2 :- { 0, 9, 12, 20 }
 * L3 :- { 5, 18, 22, 30 }
 * Output:-  {20,24}
 */
public class ShortestRangeInKSortedList {

    public static void main(String[] args) {

        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);

        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);

        nums.add(list1);
        nums.add(list2);
        nums.add(list3);

        shortestRange(nums);
    }

    private static void shortestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        });

        int max = Integer.MIN_VALUE;

        for (int i=0;i<nums.size();i++) {
            pq.add(new Element(i,0,nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }

    }
}

class Element {
    int row;    // the list number -> list1, list2, list3
    int index;  //index of element in each list
    int val;    //value of element in each index of each list

    Element(int row, int index, int val) {
        this.row = row;
        this.index = index;
        this.val = val;
    }
}
