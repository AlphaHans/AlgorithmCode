package com.hans.offer;

/**
 * Created by Hans on 17/2/27.
 * 题目一：输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 * <p>
 * 思路1:
 * O(n^2)复杂度,确定一个数 找数组剩下所有的数
 * <p>
 * 思路2:
 * O(n)
 * 由于是递增序列,使用双指针 一前一后
 */
public class _41_1_TwoNumbersWithSum {


    public static void main(String args[]) {
        int data[] = {1, 2, 4, 7, 11, 15};
        printTwoNumbersWithSum(data, 15);
    }

    private static void printTwoNumbersWithSum(int[] data, int sum) {
        int start = 0;
        int end = data.length - 1;
        while (start < end) {
            int startEndSum = data[start] + data[end];
            if (startEndSum == sum) {
                System.out.println("start = " + start + " end = " + end);
                System.out.println("start num = " + data[start] + " end num = " + data[end]);
                start++;
            } else if (startEndSum > sum) {
                end--;
            } else {
                start++;
            }
        }
    }
}
