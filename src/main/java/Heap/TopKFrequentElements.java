package Heap;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        Set<HashMap.Entry<Integer, Integer>> entrySet = map.entrySet();

        List<Integer> res = entrySet.stream()
                .sorted((c1,c2) -> c2.getValue().compareTo(c1.getValue()))
                .limit(k)
                .map(a -> a.getKey())
                .collect(Collectors.toList());

        int[] result = new int[res.size()];

        int i=0;
        for(int r: res) {
            result[i] = r;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        t.topKFrequent(nums,k);
    }
}
