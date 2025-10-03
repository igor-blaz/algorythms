package com.algorythms.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MirrorBrackets {

    public static void main(String[] args) {
        String s = "[{{{{{}}}}}](){[]}";
        System.out.println("ИТОГО " + isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                //если открывается то кладем в стек
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                System.out.println("Stack + " + stack);
                char open = stack.pop();
                if (c == ')' && open != '(') return false;
                if (c == ']' && open != '[') return false;
                if (c == '}' && open != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}


