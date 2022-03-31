package com.leetcode.general;

public class LC5 {
    public String longestPalindrome(String s) {
        /*
         * For each character in the middle (i), there are two cases:
         * odd length: move i-j and i+j until s.charAt(i-j) != s.charAt(i+j)
         * even length: move i-j and i+1+j until s.charAt(i-j) != s.charAt(i+1+j)
         */

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }

            j--;
            if (2 * j + 1 > res.length())
                res = s.substring(i - j, i + j + 1);

            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                j = 0;
                while (i - j >= 0 && i + 1 + j < s.length() && s.charAt(i - j) == s.charAt(i + 1 + j)) {
                    j++;
                }
                j--;
                if (2 * j + 2 > res.length())
                    res = s.substring(i - j, i + 1 + j + 1);
            }
        }

        return res;
    }
}
