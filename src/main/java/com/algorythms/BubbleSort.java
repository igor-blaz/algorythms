package com.algorythms;

import java.util.List;

public class BubbleSort {

    public static long go(List<Integer> numbers) {
        long start = System.nanoTime();
        int n = numbers.size() - 1; //сколько раз нам нужно пройти массив

        for (int arrayPass = 0; arrayPass < n; arrayPass++) {
            boolean swapped = false;
            //n - arrayPass это сколько осталось пройти
            for (int i = 0; i < n - arrayPass; i++) {

                //если первый элемент больше второго
                //тогда делаем перестановку

                if (numbers.get(i) > numbers.get(i + 1)) {
                    int big = numbers.get(i);
                    int small = numbers.get(i + 1);
                    numbers.set(i + 1, big);
                    numbers.set(i, small);
                    swapped = true;
                }
            }
            //если не было перестановок, то массив
            //отсортирован и проверять дальше не имеет смысла
            if (!swapped) break;
        }
       // System.out.println(numbers);
        long end = System.nanoTime();
        return end - start;

    }


}
