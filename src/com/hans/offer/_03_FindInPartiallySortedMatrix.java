package com.hans.offer;

/**
 * Created by Hans on 17/2/9.
 * 在二维数组中寻找某个数的位置
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 */
public class _03_FindInPartiallySortedMatrix {

    public static void main(String args[]) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int targetNum = 14;
        Position pos = findPosition(matrix, targetNum, 4, 4);
        if (pos != null) {
            System.out.println(pos.toString());
        } else {
            System.out.println("未找到");
        }
    }


    /**
     * @param matrix
     * @param num      需要寻找的数字
     * @param totalRow
     * @param totalCol
     * @return
     */
    private static Position findPosition(int[][] matrix, int num, int totalRow, int totalCol) {
        //判空
        if (matrix == null || totalCol == 0 || totalRow == 0) return null;
        Position pos = null;
        int row = 0;//从第0行开始查找
        int col = totalCol - 1;//从最右边找起
        while (row < totalRow && col >= 0) {//如果行数小于等于最大行数,且列数大于等于0 说明还有数
            int currentNum = matrix[row][col];//当前数
            if (currentNum == num) {
                pos = new Position();
                pos.col = col;
                pos.row = row;
                break;
            } else if (currentNum < num) {//如果小于目标数字,那么则需要向下走一行
                row += 1;
            } else {//如果大于目标数字,则需要向左走一列
                col -= 1;
            }
        }
        return pos;
    }

    public static class Position {
        public int row;//行
        public int col;//列

        @Override
        public String toString() {
            return "Position{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
