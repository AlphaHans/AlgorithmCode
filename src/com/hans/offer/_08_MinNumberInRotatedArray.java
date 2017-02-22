package com.hans.offer;

/**
 * Created by Hans on 17/2/19.
 * 旋转数组的最小值
 */
public class _08_MinNumberInRotatedArray {
    public static void main(String args[]) {
        int[][] data = {{3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2},
                {2, 2, 2, 2, 2, 2, 2, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 2},
                {1, 2, 3, 4, 5, 6},
                {2, 3, 4, 1, 2}};

        for (int i = 0; i < data.length; i++) {
            int minPos = getMinPos(data[i], 0, data[i].length - 1);
            System.out.println(data[i][minPos]);
        }
    }

    private static int getMinPos(int[] data, int start, int end) {
        if (end - start <= 1) {
            //当两者相邻的时候,其中之一必定是最小值的位置
            if (data[end] > data[start]) {
                return start;
            }
            return end;
        }
        if (data[start] < data[end]) return start;//考虑{1,2,3,4,5,6}

        int mid = (start + end) / 2;

        if (data[mid] == data[start] && data[mid] == data[end]) {//{1, 0, 1, 1, 1} 考虑无法处理递增数列的情况
            return getMinPosInOrder(data, start, end);
        }

        if (data[mid] >= data[start]) {//说明依然处于递减序列中,这里一定是>=,才能使{2,2,2,2,2,1}这种情况纳入
            return getMinPos(data, mid, end);
        } else if (data[mid] < data[start]) {//说明处于递增序列中
            return getMinPos(data, start, mid);
        }
        return 0;//不可能发生
    }

    /**
     * 顺序查找
     * @param data
     * @param start
     * @param end
     * @return
     */
    private static int getMinPosInOrder(int[] data, int start, int end) {
        int min = data[start];
        int minPos = start;
        for (int i = start; i <= end; i++) {
            if (data[i] < min) {
                min = data[i];
                minPos = i;
            }
        }
        return minPos;
    }
}
