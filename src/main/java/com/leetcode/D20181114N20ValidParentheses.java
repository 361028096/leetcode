package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * TODO description
 *
 *
 * @date 2018/11/14
 */
public class D20181114N20ValidParentheses {
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.empty() && map.get(c).compareTo(stack.peek()) == 0) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("["));
    }
}
