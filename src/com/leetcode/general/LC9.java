package com.leetcode.general;

public class LC9 {
    /**
     * Similar to LC7, but you dont need to deal with overflow, since overflow will not be equal
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0 || x < 10)
            return true;
        int origin = x;
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            res = res * 10 + tail;
            x /= 10;
        }
        return res == origin;
    }
}
