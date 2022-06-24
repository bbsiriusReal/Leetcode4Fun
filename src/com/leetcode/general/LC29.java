package com.leetcode.general;

public class LC29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : 0 - dividend;
        }

        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
        long res = 0, current = 1, sum = b;

        // write while(a >= b) by mistake
        while (a <= b) {
            if (a >= sum) {
                a -= sum;
                res += current;
                sum <<= 1;
                current <<= 1;
            } else {
                current = 1;
                sum = b;
            }
        }

        if (sign)
            return (int) res;
        else
            return 0 - (int) res;

    }
}
