package com.leetcode.general;

public class LC6 {
    public String convert(String s, int numRows) {
        /*
         * I am putting the character in place into different array of StringBuilder (or String is also fine)
         * Basically move down until the last row, then move up until the first row (skipping the first and last row)
         */
        if (numRows == 1)
            return s;
        if (s.length() <= 2)
            return s;

        StringBuilder[] sbArray = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            sbArray[i] = new StringBuilder();
        int row = 0, i = 0;
        boolean down = true;
        while (i < s.length()) {
            char c = s.charAt(i++);
            sbArray[row].append(c);
            row = down ? row + 1 : row - 1;
            if (row == numRows) {
                down = !down;
                row -= 2;
            }

            // I did make a mistake here, by putting else if here, which causes -1 if numRows == 2
            // Basically what I want here is to move down again when i reach row == 0, first time does not count
            if (row == 0) {
                down = !down; // you can also put **down = true** here
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder sb1 : sbArray)
            sb.append(sb1);
        return sb.toString();
    }
}
