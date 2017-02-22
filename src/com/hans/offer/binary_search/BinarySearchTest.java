package com.hans.offer.binary_search;

/**
 * Created by Hans on 17/2/9.
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(binarySearchRecursion(data, 0, data.length - 1, 7));
        System.out.println(binarySearchWhile(data, 0, data.length - 1, 7));
    }

    /**
     * 递归实现
     *
     * @param data  数组
     * @param start 开始位置
     * @param end   结束位置
     * @param key   目标数字
     */
    public static int binarySearchRecursion(int[] data, int start, int end, int key) {
        int mid = (start + end) / 2;
        if (data[mid] > key) {
            return binarySearchRecursion(data, start, mid - 1, key);
        } else if (data[mid] < key) {
            return binarySearchRecursion(data, mid + 1, end, key);
        } else if (data[mid] == key) {
            return mid;
        }
        return -1;
    }

    /**
     * While循环实现
     *
     * @param data
     * @param start
     * @param end
     * @param key
     * @return
     */
    public static int binarySearchWhile(int[] data, int start, int end, int key) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (data[mid] < key) {
                start = mid + 1;
            } else if (data[mid] > key) {
                end = mid - 1;
            } else if (data[mid] == key) {
                return mid;
            }
        }
        return -1;
    }
}
