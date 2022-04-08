package com.leetcode.general;

public class LC28 {
    /**
     * Typical KMP, do a google search on how this works.
     * TL;DR: in order to efficiently find strStr from needle, we need to build a aux array KMP
     * which represents the max pre with same tail
     * say needle = abcab -> kmp = [0, 0, 0, 1, 2]
     * here 1 means until here (abca), there is max length of 1 that is both head and tail (a)
     * here 2 means until here (abcab), there are max length of 2 that is both head and tail (ab)
     * <p>
     * Why is this useful?
     * Say you haystack = abcax, needle = abcba
     * when you are searching to x, normally it does not match, you need to start over from beginning
     * however, since abca -> [0, 0, 0, 1] means there is there is a that is both head and tail,
     * all you need to compare is the second char, which is b, you dont need to start over again, which saves time
     */
    public int strStr(String haystack, String needle) {
        int[] kmp = buildKMP(needle.toCharArray());
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = kmp[j - 1];
                }
            }
        }

        //made a mistake here, should be i - needle.length()
        return j == needle.length() ? i -
                /*haystack.length()*/ needle.length() : -1;

    }

    private int[] buildKMP(char[] array) {
        int[] res = new int[array.length];
        int i = 0, j = 1;
        while (j < array.length) {
            if (array[i] == array[j]) {
                res[j++] = ++i;
            } else {
                if (i == 0)
                    j++;
                else
                    i = res[i - 1];
            }
        }

        return res;
    }
}
