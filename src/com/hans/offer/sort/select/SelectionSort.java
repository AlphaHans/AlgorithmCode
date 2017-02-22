package com.hans.offer.sort.select;

/**
 * Created by Hans on 17/2/9.
 * 它的工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort {

    public static int[] sort(int[] data) {
        //这里-1的原因是因为,最后一位不需要再继续找了比他大的了,因为比他大的都已经拍好了
        for (int i = 0; i < data.length - 1; i++) {
            int minPos = i;
            int minData = data[minPos];
            //如果是遇到最后一位 那么则没有必要往后找更大的数字了
            //找到更大的数字
            for (int j = i + 1; j < data.length; j++) {
                if (minData > data[j]) {
                    minData = data[j];
                    minPos = j;
                }
            }
            //然后和当前i位置的数交换
            int temp = data[i];
            data[i] = data[minPos];
            data[minPos] = temp;
        }
        return data;
    }
}
