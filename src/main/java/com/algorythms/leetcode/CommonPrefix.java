package com.algorythms.leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonPrefix {
    static List<Character> common = new ArrayList<>();

    public static void main(String[] args) {
        String[] strs = {"interspecies", "interstellar", "interstate"};
        System.out.println(longestCommonPrefix(strs));
    }


    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Arrays.stream(strs).mapToInt(String::length).min().orElse(0);
        int i = 0;
        for (; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, i);
    }

}