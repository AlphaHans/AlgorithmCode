package com.hans.offer;

/**
 * Created by Hans on 17/2/19.
 * 二进制中1的个数
 * <p>
 * 二进制中1的个数:
 * 方法1:使用1 逐位相 & 如果得到的结果是!=0 那么则++   然后1左移一位 重复。  时间复杂度,对于Java是 32。 因为int是32位
 * <p>
 * 方法2:时间复杂度:有多少个1就多少次
 * n=(n-1) & n  通过循环直到n=0的时候,那么就知道一共有多少了。  n-1的话,这样不断借位,在于二进制的体现就是,每次都会有一位从1变成0
 */
public class _10_NumberOf1InBinary {


    public static void main(String args[]) {
//        System.out.println(numberOf1(-10));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(numberOf1_2(-10));
    }



    /**
     * 负数的时候会引起死循环  因为负数的最高位是1 负数右移 左边会补1 这样子就会无限循环下去
     *
     * @param n
     * @return
     */
    private static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 可以解决上面方法带来的死循环问题。 移动的是flag,而不是n本身。 0000 0000 0000 0001 -> 0000 0000 0000 0010 这样一直&过去,就发现他的位数了。
     *
     * @param n
     * @return
     */
    private static int numberOf1_2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 最优化解法 有多少个1就循环多少次  思想是借位-1然后与自身向&。
     * 11111111111111111111111111110110  - 1 = 11111111111111111111111111110101 然后相&
     * 11111111111111111111111111110100  - 1 = 11111111111111111111111111110011 然后向&
     * 11111111111111111111111111110000
     * 11111111111111111111111111100000
     * 11111111111111111111111111000000
     * 11111111111111111111111110000000
     * 11111111111111111111111100000000
     * 11111111111111111111111000000000
     * 11111111111111111111110000000000
     * 11111111111111111111100000000000
     * 11111111111111111111000000000000
     * 11111111111111111110000000000000
     * 11111111111111111100000000000000
     * 11111111111111111000000000000000
     * 11111111111111110000000000000000
     * 11111111111111100000000000000000
     * 11111111111111000000000000000000
     * 11111111111110000000000000000000
     * 11111111111100000000000000000000
     * 11111111111000000000000000000000
     * 11111111110000000000000000000000
     * 11111111100000000000000000000000
     * 11111111000000000000000000000000
     * 11111110000000000000000000000000
     * 11111100000000000000000000000000
     * 11111000000000000000000000000000
     * 11110000000000000000000000000000
     * 11100000000000000000000000000000
     * 11000000000000000000000000000000
     * 10000000000000000000000000000000
     * 0
     *
     * @param n
     * @return
     */
    private static int numberOf1_3(int n) {
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
            System.out.println(Integer.toBinaryString(n));
        }
        return count;
    }
}
