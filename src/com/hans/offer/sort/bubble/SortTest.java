package com.hans.offer.sort.bubble;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/9.
 */
public class SortTest {
    public static void main(String args[]) {
        int[] data = {9, 8, 7, 3, 5, 4, 6, 1, 2, 0};
//        System.out.println(Arrays.toString(data));
//        data = BubbleSort.sort(data);
//        System.out.println(Arrays.toString(data));

        int[] data2 = {9,0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(BubbleSort.sortAvd(data2)));
    }
}
