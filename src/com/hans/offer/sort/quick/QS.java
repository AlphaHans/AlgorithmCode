package com.hans.offer.sort.quick;

/**
 * reated by Hans on 17/2/18.
 */
public class QS {

    public static int[] sort(int data[]) {
        qSort(data, 0, data.length - 1);
        return data;
    }

    private static void qSort(int[] data, int start, int end) {
        if (start < end) {
            int pivotLoc = partition(data, start, end);
            if (pivotLoc != -1) {
                qSort(data, start, pivotLoc - 1);
                qSort(data, pivotLoc + 1, end);
            }
        }
    }

    private static int partition(int[] data, int start, int end) {
        if (start >= end) return -1;
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (left < right && data[left] < data[end]) {
                left++;
            }
            while (left < right && data[right] > data[end]) {
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
        if (left == right) return;
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }
}
