package com.hans.offer;

import java.util.Stack;

/**
 * Created by Hans on 17/2/23.
 * 检验栈的序列可能性
 */
public class _22_StackPushPopOrder {

    public static void main(String args[]) {
        int[] data = {1, 2, 3, 4, 5};
        int[] truePopOrder =
//                {4, 5, 3, 2, 1}
                {2, 1, 5, 4, 3};
        int[] falsePopOrder = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(data, truePopOrder));
        System.out.println(isPopOrder(data, falsePopOrder));

    }

    private static boolean isPopOrder(int[] data, int[] popOrder) {
        if (data.length != popOrder.length) return false;

        Stack<Integer> stack = new Stack<>();
        int popPos = 0;
        //压入栈过程比较
        for (int i = 0; i < data.length; i++) {
            //检验是否与压入前一个相同
            if (!stack.empty() && popOrder[popPos] == stack.peek()) {
                stack.pop();
                popPos++;
            }
            stack.push(data[i]);
            //检验是否与当前压入的相同
            if (popOrder[popPos] == stack.peek()) {
                stack.pop();
                popPos++;
            }
        }

        //压入完成开始比较
        for (int i = popPos; i < popOrder.length && !stack.empty(); i++) {
            if (popOrder[i] == stack.peek()) {
                stack.pop();
            }
        }

        //如果最终栈内都谈完,说明序列正确
        return stack.size() == 0;
    }

}
