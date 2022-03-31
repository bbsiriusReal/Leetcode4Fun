package com.leetcode.general;

import java.util.HashMap;
import java.util.Map;

public class LC1 {
    // basically you put a map: num -> index
    // when you find the num you want: target - num, you return index of the two
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(target - num)) {
                return new int[]{map.get(target- num), i};
            }
            map.put(num, i);
        }

        return new int[2];
    }
}
