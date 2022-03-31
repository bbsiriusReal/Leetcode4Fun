package com.leetcode.general;

public class LC8 {
    /**
     * Quite straightforward. A few corner cases
     * 1. Need to trim
     * 2. If s is empty, or first character is not +, -, or digit, return 0
     * 3. determin postivie or negative.
     * 4. go through every character, adds up to value
     * 5. overflow -> return
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int i = 0;
        Boolean sign = null;
        if (s.charAt(i) == '-') {
            sign = false;
            i++;
        } else if (s.charAt(i) == '+') {
            sign = true;
            i++;
        } else if (Character.isDigit(s.charAt(i))) {
            sign = true;
        } else {
            return 0;
        }

        long res = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i++) - '0';
            res = sign ? 10 * res + num : 10 * res - num;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                break;
        }

        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) res;
    }
}
