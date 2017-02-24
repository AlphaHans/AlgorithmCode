package com.hans.offer;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/24.
 * 最小的K个数
 * <p>
 * 思路一:
 * 利用快排,时间复杂度 O(nlogn);
 * <p>
 * 思路二:
 * {@link _29_FindMoreThanHalfNum}扩展思路,当pivot==k-1的时候,说明他的左边都是比k-1小的。(虽然不是有序的) 时间复杂度为O(n)
 * <p>
 * 思路三:
 * 海量数据解法
 */
public class _30_KLeastNumbers {


    public static void main(String args[]) {
        int data[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11, 8, 8, 8, 8, 8};

        findKLeastNumByPartition(data, 3);
        System.out.println(Arrays.toString(data));
    }

    private static void findKLeastNumByPartition(int[] data, int k) {
        int start = 0;
        int end = data.length - 1;
        int pivot = partition(data, start, end);
        while (pivot != k) {
            if (pivot > k) {
                end = pivot - 1;
                pivot = partition(data, start, end);
            } else {
                start = pivot + 1;
                pivot = partition(data, start, end);
            }
        }
    }

    private static int partition(int[] data, int start, int end) {
        if (start == end) return start;
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (left < right && data[left] <= data[end]) {
                left++;
            }
            while (left < right && data[right] >= data[end]) {
                right--;
            }
            swap(data, left, right);
        }
        if (data[left] > data[end]) {
            swap(data, left, end);
        } else {
            left++;
        }
        return left;
    }

    private static void swap(int[] data, int left, int right) {
        if (left != right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }
}
