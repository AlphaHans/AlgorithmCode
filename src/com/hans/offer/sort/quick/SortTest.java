package com.hans.offer.sort.quick;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/10.
 */
public class SortTest {

    public static void main(String args[]) {
        int[] data = {10, 9, 8, 11, 12, 7, 6, 4, 3, 2, 5, 15, -1};
        System.out.println(Arrays.toString(QS.sort(data)));
    }
}
