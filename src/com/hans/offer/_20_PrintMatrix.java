package com.hans.offer;

/**
 * Created by Hans on 17/2/21.
 * 顺时针打印矩阵
 *
 * 1.先考虑如何 打印上横 右列 下横 左列  不过要注意,可能只有一横的情况,即startY = endY 所以不要重复打印
 * 2.然后再考虑如何获得坐标的问题。 实际上就是(start,start) 和 二维数组的行列关系 start<cols/2 && start<rows/2
 */
public class _20_PrintMatrix {


    public static void main(String args[]) {
//        int[][] data = {
//                {1, 2, 3, 4, 5, 6},
//                {7, 8, 9, 10, 11, 12},
//                {13, 14, 15, 16, 17, 18},
//                {19, 20, 21, 22, 23, 24},
//                {25, 26, 27, 28, 29, 30},
//                {31, 32, 33, 34, 35, 36}
//        };
        int[][] data = {{1}};

        printMatrix(data);
    }

    /**
     * @param data
     */
    private static void printMatrix(int[][] data) {
        if (data[0].length == 0 || data.length == 0) return;
        int xMax = data[0].length;
        int yMax = data.length;
        int start = 0;
        while (xMax > start * 2 && yMax > start * 2) {
            printMatrixInCircle(data, start);
            start++;
        }
    }

    private static void printMatrixInCircle(int[][] data, int start) {
        int endX = data[0].length - 1 - start;
        int endY = data.length - 1 - start;

        for (int j = start; j <= endX; j++) {//上面一行
            System.out.print(data[start][j] + " ");
        }

        for (int j = start + 1; j <= endY; j++) {//右边一列
            System.out.print(data[j][endX] + " ");
        }

        if (endY != start)
            for (int j = endX - 1; j >= start; j--) {//下面一行
                System.out.print(data[endY][j] + " ");
            }

        if (endX != start)
            for (int j = endY - 1; j >= start + 1; j--) {
                System.out.print(data[j][start] + " ");
            }

        System.out.println();
    }
}
