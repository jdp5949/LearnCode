package leetcode;

import java.util.Arrays;
import java.util.HashMap;
class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];//main line
            if(hm.containsKey(diff)){
                return new int[]{hm.get(diff),i};
            }
            hm.put(nums[i],i);
        }
        return new int[0];
    }
}

//o(n) o(n)