package com.hans.offer;

/**
 * Created by Hans on 17/2/26.
 * 题目 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O（n）。
 */
public class _31_MaxSumInSubArrays {


    public static void main(String args[]) {
        int data[] = {1, -2, -3, 10, -4, 7, 2, -5};
        int maxSum = getMaxSum(data);
        System.out.println(maxSum);
    }

    private static int getMaxSum(int[] data) {
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < data.length - 1; i++) {
            if (currentSum <= 0) {//如果前面的和小于0,那么相加后面也没啥意义。 还不如重新在该i位开始相加
                currentSum = data[i];
            } else {
                currentSum += data[i];//大于0 则继续加
            }
            if (currentSum > maxSum) {//比较
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
