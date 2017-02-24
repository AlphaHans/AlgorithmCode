package com.hans.offer;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/24.
 * 寻找数组中超过一半的数字
 * <p>
 * 思路一:
 * 借鉴快拍中partition的思路,如果然后的枢轴位置刚好位于数组中间,那么这个数字肯定是超过一半的数字(根据统计学中,超过一半的数字,肯定是这个数组的中值)
 * <p>
 * 思路二:
 * 借助Hash表
 * <p>
 * 思路三:
 * 剑指offer还有一种思路: 出现超过一半的数,也就是比其他数出现的次数的总和还多
 */
public class _29_FindMoreThanHalfNum {

    public static void main(String args[]) {
//        int[] data = {2, 2, 2, 2, 2, 2, 2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 21, 32, 45, 16, 12, 45};
        int[] data = {2, 2, 2, 2, 1, 3, 4, 2, 2, 6, 7, 2, 8};
        int pos = findMoreThanHalfNum(data);
        System.out.println(data[pos]);
        System.out.println(Arrays.toString(data));
    }

    private static int findMoreThanHalfNum(int[] data) {
        int middle = data.length >> 1;//中间值位置
        int pivot = partition(data, 0, data.length - 1);
        int start = 0;
        int end = data.length - 1;
        while (pivot != middle) {
            if (pivot > middle) {//说明在右边
                end = pivot - 1;
                pivot = partition(data, start, end);
            } else {
                start = pivot + 1;
                pivot = partition(data, start, end);
            }
        }
        return pivot;
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
