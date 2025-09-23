package com.algorythms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static long go(List<Integer> numbers) {
        long start = System.nanoTime();
        mergeSort(numbers, 0, numbers.size() - 1);
        long end = System.nanoTime();
        return end - start;
    }

    public static void mergeSort(List<Integer> numbers, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;

        mergeSort(numbers, left, mid);       // левая половина
        mergeSort(numbers, mid + 1, right); // правая половина
        merge(numbers, left, mid, right);

    }

    private static void merge(List<Integer> numbers, int left, int mid, int right) {
        //пустой массив
        List<Integer> temp = new ArrayList<>();

        int leftIndex = left;       // идём по левой половине
        int rightIndex = mid + 1;   // идём по правой половине

        while (leftIndex <= mid && rightIndex <= right) {
            if (numbers.get(leftIndex) <= numbers.get(rightIndex)) {
                temp.add(numbers.get(leftIndex++));
            } else {
                temp.add(numbers.get(rightIndex++));
            }
        }

        // остатки слева
        while (leftIndex <= mid) {
            temp.add(numbers.get(leftIndex++));
        }

        // остатки справа
        while (rightIndex <= right) {
            temp.add(numbers.get(rightIndex++));
        }
        System.out.println(temp);
    }


}
