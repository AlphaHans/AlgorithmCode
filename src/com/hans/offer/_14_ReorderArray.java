package com.hans.offer;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/20.
 * 调整数组顺序使奇数位于偶数前面
 * <p>
 * 思路1:使用双指针模式:start end 一个一个对换。 不保证原本相对位置
 * 思路2: 使用直接插入思想。 这样可以保证 保证原本相对位置
 */
public class _14_ReorderArray {

    public static void main(String args[]) {
        int[] arr = {0, 2, 4, 6, 8, 1, 3, 5, 7};
        reorderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reorderArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && (arr[left] & 0x1) == 1) {//说明是奇数
                left++;
            }
            while (left < right && (arr[right] & 0x1) != 1) {//说明是偶数
                right--;
            }
            swap(arr, left, right);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
