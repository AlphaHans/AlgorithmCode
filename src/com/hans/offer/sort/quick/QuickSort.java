package com.hans.offer.sort.quick;

/**
 * Created by Hans on 17/2/10.
 */
public class QuickSort {

    public static int[] sort(int[] data) {
        if (data.length == 0) return data;
        quickSort(data, 0, data.length - 1);
        return data;
    }

    public static int[] sort2(int[] data) {
        if (data.length == 0) return data;
        quickSort2(data, 0, data.length - 1);
        return data;
    }

    private static void quickSort2(int[] data, int start, int end) {
        int pivotLoc;
        if (start < end) {
            pivotLoc = partition(data, start, end);
            if (pivotLoc != -1) {
                quickSort2(data, start, pivotLoc - 1);
                quickSort2(data, pivotLoc + 1, end);
            }
        }
    }

    private static int partition(int[] data, int start, int end) {
        if (start >= end) return -1;
        int startValue = data[start];//以第一位作为枢轴
        int left = start + 1;
        int right = end;
        while (left < right) {
            while (left < right && data[left] <= startValue) {
                left++;
            }
            while (left < right && data[right] >= startValue) {
                right--;
            }
            swap(data, left, right);
        }
        //将枢轴的值放到他应该方的位置
        if (data[left] < data[start]) {
            swap(data, start, left);
        } else {
            left++;
        }
        return left;
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start >= end) return;
        int baseNum = data[end];//以最后一位作为基准数
        int left = start, right = end - 1;//数组左侧指针,数组右侧指针
        while (left < right) {//直到left==right才停止
            //找出左指针指出小于基准数的位置
            while (data[left] < baseNum && left < right) {
                left++;
            }
            //找出右指针指出大于基准数的位置
            while (data[right] >= baseNum && left < right) {
                right--;
            }
            swap(data, left, right);
        }
        if (data[left] > baseNum) {//检测当前中间数与基准数的大小
            swap(data, left, end);
        } else {
            left++;
        }
        quickSort(data, start, left - 1);
        quickSort(data, left + 1, end);
    }

    private static void swap(int[] data, int left, int right) {
        int temp = data[right];
        data[right] = data[left];
        data[left] = temp;
    }
}
