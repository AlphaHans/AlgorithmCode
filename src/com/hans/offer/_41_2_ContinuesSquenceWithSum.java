package com.hans.offer;

/**
 * Created by Hans on 17/2/27.
 * 题目一：输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 * <p>
 * 思路:
 * 用一个small 和一个big来表示。
 * 1.当small-big的总和加起来等于目标数字 则输出。
 * 输出后重置small++; big=small+1; 进行下轮序列输出。 结束条件是small<(num+1)/2或(num/2) 均可
 * 2.当small—big的总和小于,那么big++
 * 3.当small-big的总和大于,那么如同1一样的重置
 */
public class _41_2_ContinuesSquenceWithSum {

    public static void main(String args[]) {
        printContinuesSquenceWithSum(3);
    }

    private static void printContinuesSquenceWithSum(int sum) {
        int small = 1;
        int big = 2;
        int smallToBigSum = small + big;
        while (small != (sum + 1) / 2) {
            if (smallToBigSum < sum) {
                big++;
                smallToBigSum += big;
            } else if (smallToBigSum == sum) {
                printSmallToBig(small, big);
                small++;
                big = small + 1;
                smallToBigSum = small + big;
            } else if (smallToBigSum > sum) {
                small++;
                big = small + 1;
                smallToBigSum = small + big;
            }
        }
    }

    private static void printSmallToBig(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
