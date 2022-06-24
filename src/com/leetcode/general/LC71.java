package com.leetcode.general;

import java.util.Deque;
import java.util.LinkedList;

public class LC71 {
    public String simplifyPath(String path) {
        path = path.trim();
        if (path.length() == 0) {
            return "/";
        }
        String[] directory = path.split("\\/");
        Deque<String> stack = new LinkedList<>();
        for (String str : directory) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            if (str.length() == 0)
                continue;
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pop());
        }

        return sb.toString();
    }
}
