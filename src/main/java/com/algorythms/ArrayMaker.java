package com.algorythms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayMaker {
    public static final List<Integer> numbers = new ArrayList<>();

    static {
        generateNumbers(12, 100);
    }

    private static void generateNumbers(int size, int bound) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(bound));
        }
    }
}
