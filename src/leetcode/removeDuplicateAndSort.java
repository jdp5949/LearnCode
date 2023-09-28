package leetcode;
import java.util.*;

import static java.util.Arrays.sort;
public class removeDuplicateAndSort {
    public static int[] topKFrequent(int[] nums, int k) {
        int [] ans = new int[k];
        HashMap <Integer,Integer> map =new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> l = new ArrayList<>(map.keySet());
        Collections.sort(l, (a, b) -> map.get(b) - map.get(a));
        for (int i = 0; i < k; i++) {
            ans[i] = l.get(i);
            System.out.println(ans[i]);
        }
        return ans;
    }
}
