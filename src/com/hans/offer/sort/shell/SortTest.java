package com.hans.offer.sort.shell;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/9.
 */
public class SortTest {
    public static void main(String args[]) {
        int[] data = {0, 4, 5, 6, 1, 8, 2, 9, 3};
        System.out.println(Arrays.toString(ShellSort.sortAdv(data)));
    }
}
