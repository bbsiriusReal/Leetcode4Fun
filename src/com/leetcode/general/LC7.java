package com.leetcode.general;

public class LC7 {
    public int reverse(int x) {
        /* Basically, loop until x == 0, each time, add the last bit of x to the right of the result
         * The only trick is how to deal with overflow without using long or unsigned int
         */
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            x /= 10;
            int num = res * 10 + tail;
            // if without considering overflow, below two lines can be ignored
            // the trick here without using long (64 bit) or even longer bits are,
            // if overflows, below number does not match
            if ((num - tail) / 10 != res)
                return 0;
            res = res * 10 + tail;
        }
        return res;
    }
}
