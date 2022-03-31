package com.leetcode.general;

import java.util.HashSet;
import java.util.Set;

public class LC3 {

    public int lengthOfLongestSubstring(String s) {
        /*
         * Typical sliding window question, have left and right to mark the window
         * Always move right -> right+1, move left only when you find you already see this char
         */
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            if (right - left > res) {
                res = right - left;
            }
        }

        return res;

    }
}
