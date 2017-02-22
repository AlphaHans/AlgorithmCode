package com.hans.offer.sort.merge;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/10.
 */
public class SortTest {

    public static void main(String args[]){
        int[] data = {0, 4, 5, 6, 1, 8, 2, 9, 3, 7};
        System.out.println(Arrays.toString(MergeSort.sort(data)));
    }
}
