package com.algorythms.sortingAlgorythms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static final Logger log = LoggerFactory.getLogger(MergeSort.class);
    static int i = 0;

    public static long go(List<Integer> numbers) {
        long start = System.nanoTime();
        mergeSort(numbers, 0, numbers.size() - 1);
        long end = System.nanoTime();
        return end - start;
    }

    public static void mergeSort(List<Integer> numbers, int left, int right) {
        log.info("вызов MergeSort номер {}", ++i);
        // left — это самый первый индекс
        // right — это самый последний индекс
        if (left >= right) {
            log.info("базовый случай left = {} right = {}", left, right);
            return;
        }
        log.info("Базовый случай не произошел left = {} right = {}", left, right);
        int mid = (left + right) / 2;
        // mid — это середина. Далее мы расщепляем левую и правую половину
        mergeSort(numbers, left, mid);       // левая половина
        mergeSort(numbers, mid + 1, right);  // правая половина
        merge(numbers, left, mid, right);
    }

    private static void merge(List<Integer> numbers, int left, int mid, int right) {
        log.info("Вызов merge left {} mid {} right {}", left, mid, right);
        List<Integer> temp = new ArrayList<>();

        int leftIndex = left;       // идём по левой половине
        int rightIndex = mid + 1;   // идём по правой половине

        while (leftIndex <= mid && rightIndex <= right) {
            log.info("сортировка ");
            log.info("temp до сортировки {}", temp);
            if (numbers.get(leftIndex) <= numbers.get(rightIndex)) {
                temp.add(numbers.get(leftIndex++));
                log.info("1 шаг сортировки {}", temp);
            } else {
                temp.add(numbers.get(rightIndex++));
                log.info("1 шаг сортировки {}", temp);
            }
        }

        // остатки слева
        while (leftIndex <= mid) {
            temp.add(numbers.get(leftIndex++));
            log.info("2 шаг сортировки {}", temp);
        }

        // остатки справа
        while (rightIndex <= right) {
            temp.add(numbers.get(rightIndex++));
            log.info("2 шаг сортировки {}", temp);
        }
        log.info("результат merge {}", temp);
    }
}
