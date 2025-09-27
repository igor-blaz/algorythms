package com.algorythms.leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int romanToInt(String s) {
        int[] ints = new int[s.length()];
        Map<String, Integer> num = new HashMap<>(7);
        num.put("I", 1);
        num.put("V", 5);
        num.put("X", 10);
        num.put("L", 50);
        num.put("C", 100);
        num.put("D", 500);
        num.put("M", 1000);
        String[] strings = s.split("");

        int len = strings.length;
        for (int i = 0; i < strings.length; i++) {
            ints[i] = num.get(strings[i]);
        }
        int i = 0;
        int sum = 0;
        while (i < len) {
            if (i + 1 < len && ints[i] < ints[i + 1]) {
                sum += (ints[i + 1] - ints[i]);
                i += 2;
            } else {
                sum += ints[i];
                i += 1;
            }
        }
        return sum;
    }

//    class Solution {
//        public int romanToInt(String s) {
//            int sum = 0;
//            int prev = 0; // значение символа справа от текущего
//
//            for (int i = s.length() - 1; i >= 0; i--) {
//                int v = value(s.charAt(i));
//                if (v < prev) sum -= v;   // вычитание (IV, IX, XL, XC, CD, CM)
//                else          sum += v;   // сложение
//                prev = v;
//            }
//            return sum;
//        }
//
//        private int value(char c) {
//            switch (c) {
//                case 'I': return 1;
//                case 'V': return 5;
//                case 'X': return 10;
//                case 'L': return 50;
//                case 'C': return 100;
//                case 'D': return 500;
//                case 'M': return 1000;
//                default: throw new IllegalArgumentException("Bad roman char: " + c);
//            }
//        }
//    }

}