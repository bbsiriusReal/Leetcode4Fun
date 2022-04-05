package com.leetcode.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    /*
     *  This is the first wrong version I submit, the problem I have is having duplicate.
     *  I thought about only adding left++ or right-- if sum==0, neither work,
     *  then I realize, wait a min,  in order to remove duplicate, I need to skip all equal value
     */
    public List<List<Integer>> threeSumV1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }

    /*
     *  This is the second wrong version I submitted. I did skip the duplicate, but I am in a dead loop
     *  The problem with this is, if sum == 0, if nums[j] != nums[j+1], j never increase, which causes in a dead loop
     *  Fix: j++ first, then compare j to j-1; Same with K
     */
    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1])
                i++;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (k > j && nums[k] == nums[k - 1])
                        k--;
                } else if (sum < 0)
                    j++;
                else
                    k--;
            }

        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1])
                i++;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (k > j && nums[k] == nums[k + 1])
                        k--;
                } else if (sum < 0)
                    j++;
                else
                    k--;
            }

        }

        return res;
    }
}
