package com.algorythms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = ArrayMaker.numbers;
        long bubbleSortTime = BubbleSort.go(new ArrayList<>(array));
        long mergeSortTime = MergeSort.go(new ArrayList<>(array));
        System.out.println("bubble " + bubbleSortTime);
        System.out.println("merge " + mergeSortTime);

    }
}