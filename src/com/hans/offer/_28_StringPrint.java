package com.hans.offer;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/24.
 * 字符串数组的所有组合
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class _28_StringPrint {


    public static void main(String args[]) {
        int data[] = {1, 2, 3, 4};
        stringPrint(data, 0);
    }

    /**
     * 可以看成两步：首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。
     * 图4.14就是分别把第一个字符a和后面的b、c等字符交换的情形。首先固定第一个字符（如图4.14（a）所示），求后面所有字符的排列。
     * 这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。然后把第一个字符逐一和它后面的字符交换
     *
     * @param data
     * @param begin
     */
    private static void stringPrint(int[] data, int begin) {
        if (begin == data.length - 1) {
            System.out.println(Arrays.toString(data));
            return;
        }
        int i = begin;
        for (; i < data.length; i++) {
            swap(data, i, begin);
            stringPrint(data, begin + 1);
            swap(data, i, begin);
        }
    }

    private static void swap(int[] data, int i, int begin) {
        int temp = data[i];
        data[i] = data[begin];
        data[begin] = temp;
    }

    private static int[] creatNewData() {
        return new int[]{1, 2, 3, 4};
    }
}

