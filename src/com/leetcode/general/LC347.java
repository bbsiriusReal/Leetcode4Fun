package com.leetcode.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC347 {

    /*
    Very typical quick sort or bucket sort problem, Amazon likes to ask this question a lot.
    1. Naive idea is to do a sort based on frequence, either using treeMap or just build another array and sort
    Time O(n log(n))
    2. (I dont really like bucket sort). Idea is to put each freqncy's num into the same bucket, and then count from smallest bucket to largest
    Time O(n)
    3. quick sort, this is slightly worse than O(n), but very close
    Idea is to not to sort (i.e, find each number's position in the sorted array), but only to find top k
    Say you want simply top k smallest number (all distinct)
    you can just choose a pivot, put all number < pivot to left, put all number > pivot to right,
    if pivot is at the k (or k+1), all it is left is the top K, (however these k is not sorted).
    Time O(alpha * n) alpha is very close to 1.4 something.

    4. There is anotehr version of quick sort that I used a lot, but slightly complex to write than this
    put all smaller than pivot to left, put all equal to pivot to middle, put all larger than pivot to right
    then if k falls in the middle part, then you find the anser.
     */


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] index = new int[map.size()];
        int i = 0;
        for (int num : map.keySet()) {
            index[i++] = num;
        }

        sortK(index, map, k, 0, index.length - 1);
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = index[j];
        }

        return res;
    }

    private void sortK(int[] nums, Map<Integer, Integer> map, int k, int left, int right) {
        int size = right - left + 1;
        // in order to eliminate the worst case, i.e., pivot is the smallest or largest, just do a ramdom
        int random = left /* forget this in my first draft */ + (new Random()).nextInt(size);
        swap(nums, random, right);

        int pivot = nums[right];
        int i = left, j = right;

        while (i <= j) {
            if (map.get(nums[i]) >= map.get(pivot))
                i++;
            else
                swap(nums, i, j--);
        }

        if (i == k)
            return;
        else if (i < k)
            sortK(nums, map, k, i, right);
        else
            sortK(nums, map, k, left, i - 1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
