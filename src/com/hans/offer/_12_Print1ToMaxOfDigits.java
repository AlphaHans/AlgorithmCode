package com.hans.offer;

/**
 * Created by Hans on 17/2/20.
 * 打印1到最大的n位数
 *
 * 转成字符串去运算,避免溢出. 采用递归
 */
public class _12_Print1ToMaxOfDigits {


    public static void main(String[] args) {
        print1ToMaxOfDigits(10);
    }

    private static void print1ToMaxOfDigits(int digits) {
        if (digits <= 0) return;
        char[] nums = new char[digits];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = '0';
        }
        while (!isOver(nums)) {
            add(nums, nums.length - 1);
            printDigits(nums);
        }
    }

    public static void add(char[] nums, int targetPos) {
        int num = Integer.parseInt(String.valueOf(nums[targetPos]));
        num++;
        if (num == 10) {
            add(nums, targetPos - 1);//进位+1
            nums[targetPos] = '0';//进位后 原始位为0
        } else {
            nums[targetPos] = String.valueOf(num).toCharArray()[0];
        }
    }

    public static boolean isOver(char[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != '9') return false;
        }
        return true;
    }


    public static void printDigits(char[] nums) {
        boolean isPrint = false;
        for (int i = 0; i < nums.length; i++) {
            if (Integer.parseInt(String.valueOf(nums[i])) != 0 || isPrint) {
                isPrint = true;
                System.out.print(nums[i]);
            }
        }
        System.out.println();
    }
}
