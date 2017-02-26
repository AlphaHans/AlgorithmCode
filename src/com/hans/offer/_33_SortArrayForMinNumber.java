package com.hans.offer;

/**
 * Created by Hans on 17/2/26.
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3,32,321}，则打印出这3个数字能排成的最小数字321323。
 * <p>
 * 我的思路:
 * 将所有数字的最高位拿出来比较, 由例子可知 目前数组里数字最高位为3。 那么继续比较第二位,3的没有第二位,所以这个数字被排除。
 * 然后比较32和321 发现又是相等,那么比较下一位,可以发现32没有第三位,所以321是首先作为数字的头。
 * 然后以此类推。
 * 优化思路:
 * 我们可以将可能是下一位拼接的数字进行缓存,比如32 3 就是321拼接完后的待选位。 那么我们可以使用一个栈,栈不为空,栈顶元素就是下一位拼接的数字。
 * <p>
 * <p>
 * 书本的思路:
 * 很复杂。。。 没感觉比我的思路好在哪里
 */
public class _33_SortArrayForMinNumber {
}
