package com.hans.offer.sort.bubble;

/**
 * Created by Hans on 17/2/9.
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param data
     * @return
     */
    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            //结尾部分是排序好了的,所以不需要再排了
            for (int j = 0; j < data.length - i - 1; j++) {
                if (j + 1 < data.length && data[j] > data[j + 1]) {
                    swap(data, j);
                }
            }
        }
        return data;
    }

    /**
     * 优化过后的冒泡排序
     *
     * @param data
     * @return
     */
    public static int[] sortAvd(int[] data) {
        boolean isChanged = false;
        for (int i = 0; i < data.length; i++) {
            //结尾部分是排序好了的,所以不需要再排了
            isChanged = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (j + 1 < data.length && data[j] > data[j + 1]) {
                    swap(data, j);
                    isChanged = true;//发生交换说明未排序完毕
                }
            }
            if (!isChanged) {
                System.out.println("提前结束");
                return data;
            }
        }
        return data;
    }

    private static void swap(int[] data, int prePos) {
        int temp = data[prePos];
        data[prePos] = data[prePos + 1];
        data[prePos + 1] = temp;
    }
}
