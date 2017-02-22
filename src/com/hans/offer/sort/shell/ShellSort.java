package com.hans.offer.sort.shell;

/**
 * Created by Hans on 17/2/9.
 * 直接插入排序是针对已经排序的序列,插入一个新的值的排序。
 */
public class ShellSort {


    public static int[] sortAdv(int[] data) {
        int gap = data.length;
        do {
            gap = gap / 3 + 1;
            for (int i = 1; i < data.length; i++) {
                for (int j = i; j > 0; j -= gap) {
                    if (j - gap > 0 && data[j - gap] > data[j]) {
                        int temp = data[j];
                        data[j] = data[j - gap];
                        data[j - gap] = temp;
                    }
                }
            }
        } while (gap > 1);
        return data;
    }
}
