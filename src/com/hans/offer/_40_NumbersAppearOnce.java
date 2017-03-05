package com.hans.offer;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/26.
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O（n），空间复杂度是O（1）。
 * <p>
 * 思路解析:
 * 可以先想一下: 如果只有一个数字出现一次,其他数字出现两次怎么办。
 * 我们可以利用异或的特性。 如果一个数字异或自己(num^=num) 结果是抵消的。
 * 所以我们可以得出,如果一个数字出现一次的解法。
 * <p>
 * 整体思路:
 * 1.将数组划分为两个组,一个组内分别包含一个只出现一次的数字
 * 2.那么如何将两个不同的数字分到不同的组呢?
 * 3.一次for循环,得到最终异或的数字,从后往前找 找到一位为1的位
 * 4.然后将所有原数组中 该位为1的数字 分到另外一个组,剩下的一个组
 */
public class _40_NumbersAppearOnce {

    public static void main(String args[]) {
        int data[] = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
        int num = getFirstNum(data);
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(7));
        int pos = get1PosInNum(num);
        int data1[] = new int[data.length];
        int data2[] = new int[data.length];
        divideArr(data, pos, data1, data2);
        System.out.println(Arrays.toString(data1));
        System.out.println(Arrays.toString(data2));

        data1 = Arrays.copyOf(data1, count1);
        data2 = Arrays.copyOf(data2, count2);

        System.out.println(Arrays.toString(data1));
        System.out.println(Arrays.toString(data2));

        System.out.println(getNumberAppearOnce(data1));
        System.out.println(getNumberAppearOnce(data2));
    }

    private static int getNumberAppearOnce(int[] data) {
        int num = data[0];
        for (int i = 1; i < data.length; i++) {
            num ^= data[i];
        }
        return num;
    }

    static int count1 = 0;
    static int count2 = 0;

    /**
     * 划分数组
     *
     * @param data
     * @param pos
     * @param data1
     * @param data2
     */
    private static void divideArr(int[] data, int pos, int[] data1, int[] data2) {
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            if (is1BitInPos(num, pos)) {
                data1[count1] = num;
                count1++;
            } else {
                data2[count2] = num;
                count2++;
            }
        }
    }

    /**
     * 判断num的二进制pos位是否为1
     *
     * @param num
     * @param pos
     * @return
     */
    private static boolean is1BitInPos(int num, int pos) {
        return ((num >> pos) & 1) != 0;
    }

    private static int get1PosInNum(int num) {
        int pos = 0;
        while ((num & 0x1) == 0) {
            pos++;
            num = num >> 1;
        }
        return pos;
    }

    /**
     * 获取第一次异或后的数字
     *
     * @param data
     * @return
     */
    public static int getFirstNum(int data[]) {
        int num = data[0];
        for (int i = 1; i < data.length; i++) {
            num ^= data[i];
        }
        return num;
    }
}
