package Array.Ideserve;

import java.util.*;

/**
 * Design a data structure with operations Insert, Delete, Search and GetRandom in Constant Time.
 */
public class DesignDataStructure {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    DesignDataStructure() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    void add(int x) {

        if (map.get(x) != null) {
            return;
        }

        int size = list.size();
        list.add(x);

        map.put(x, size);

    }

    void delete(int x) {

        // Check if element is present
        Integer index = map.get(x);
        if (index == null)
            return;

        // If present, then remove element from map
        map.remove(x);

        // Swap element with last element so that remove from
        // list[] can be done in O(1) time
        int size = list.size();
        Integer last = list.get(size-1);
        Collections.swap(list, index,  size-1);

        // Remove last element (This is O(1))
        list.remove(size-1);

        // Update map table for new index of last element
        map.put(last, index);
    }

    Integer search(int x) {
        return map.get(x);
    }

    int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        DesignDataStructure d = new DesignDataStructure();
        d.add(10);
        d.add(20);
        d.add(30);
        d.add(40);
        d.add(50);

        d.delete(20);

        int res = d.getRandom();
        System.out.println(res);
    }
}
