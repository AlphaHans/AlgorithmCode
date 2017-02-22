package com.hans.offer.sort.heap;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/22.
 * 堆排序
 */
public class HeapSort {
    public static void main(String args[]) {
        int[] data = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }


    private static void heapSort(int[] data) {
        buildMaxHeap(data);
        System.out.println("max heap = " + Arrays.toString(data));
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            maxHeapifyWhenSort(data, 0, i);
        }
    }

    /**
     * @param data
     */
    private static void buildMaxHeap(int[] data) {
        int midPos = (data.length - 1) >> 1;//中间位置就是 非叶子节点的最后一位  (因为他的子节点计算公式是 左=2*i+1 右=2*i+2)
        for (int i = midPos; i >= 0; i--) {//从最后一个子节点进行最大堆化
            maxHeapify(data, i);
        }
    }

    /**
     * 最大堆化
     *
     * @param data
     * @param parentPos
     */
    private static void maxHeapify(int[] data, int parentPos) {
        maxHeapifyWhenSort(data, parentPos, data.length);
    }

    /**
     * 特别注意len参数
     *
     * @param data
     * @param parentPos
     * @param len       当在{@link #heapSort(int[])}方法中进行了一次swap的事后,其实最后一位是已经排好序得了,所以不参与到下次的构造大顶堆中去
     */
    private static void maxHeapifyWhenSort(int data[], int parentPos, int len) {
        int leftPos = parentPos * 2 + 1;//parent对应的左子节点在数组的位置
        int rightPos = leftPos + 1;//右子节点在数组的位置

        int maxPos = parentPos;

        if (leftPos < len && data[leftPos] > data[maxPos]) {
            maxPos = leftPos;
        }

        if (rightPos < len && data[rightPos] > data[maxPos]) {
            maxPos = rightPos;
        }

        if (maxPos != parentPos) {
            swap(data, parentPos, maxPos);
            maxHeapifyWhenSort(data, maxPos, len);//要重新调整被调整的位置的(使其换位之后,与其子节点依旧保持最大堆的形态
        }
    }

    private static void swap(int[] data, int parentPos, int maxPos) {
        int temp = data[parentPos];
        data[parentPos] = data[maxPos];
        data[maxPos] = temp;
    }
}
