package com.hans.offer;

/**
 * Created by Hans on 17/2/19.
 */
public class _09_Fibonacci {
    public static void main(String args[]) {
        System.out.println(fibonacci(10));
        System.out.println(fibonacci2(10));
    }

    /**
     * 解法1 速度奇慢无比
     *
     * @return
     */
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 解法二:可以使用Map进行键值对存储提高速度
     */

    /**
     * 解法三:使用for循环计算
     */
    public static int fibonacci2(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int first = 0;
        int second = 1;
        int fibN = 0;
        //这里从2开始
        for (int i = 2; i <= n; i++) {
            fibN = first + second;
            first = second;
            second = fibN;
        }
        return fibN;
    }
}
