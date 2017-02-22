package com.hans.offer.sort.select;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/9.
 */
public class SortTest {
    public static void main(String args[]) {
        int[] data = {9, 8, 7, 3, 5, 4, 6, 1, 2, 0};
        System.out.println(Arrays.toString(SelectionSort.sort(data)));
    }
}
