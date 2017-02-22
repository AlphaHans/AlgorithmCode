package com.hans.offer.sort.merge;

/**
 * Created by Hans on 17/2/10.
 */
public class MergeSort {
    /**
     * @param data
     * @return
     */
    public static int[] sort(int[] data) {
        int[] result = new int[data.length];
        mergeSort(data, result, 0, data.length - 1);
        return data;
    }

    /**
     * 1.将数组均分至单个为止
     * 2.从两个单个开始合并成一个组
     * 3.两个组合并成一个大组(单个组内都是有序的,因为他们是比较过后才赋值的)
     * 4.两个大组合并成一个大大组...
     * 5.....直到合并成最终
     *
     * @param data
     * @param result
     * @param start
     * @param end
     */
    private static void mergeSort(int[] data, int[] result, int start, int end) {
        if (start == end) return;
        int mid = (end + start) / 2;
        mergeSort(data, result, start, mid);
        mergeSort(data, result, mid + 1, end);
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        int k = start;

        //选择两部分小的优先放入
        while (start1 <= end1 && start2 <= end2)
            result[k++] = data[start1] < data[start2] ? data[start1++] : data[start2++];
        //考虑到第1部分还有剩的情况
        while (start1 <= end1)
            result[k++] = data[start1++];
        //考虑到第2部分还有剩的情况
        while (start2 <= end2)
            result[k++] = data[start2++];

        //赋值到原本的数组中去
        for (k = start; k <= end; k++)
            data[k] = result[k];
    }
}
