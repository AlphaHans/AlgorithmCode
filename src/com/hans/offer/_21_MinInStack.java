package com.hans.offer;

import java.util.Stack;

/**
 * Created by Hans on 17/2/23.
 * 包含最小函数的栈
 */
public class _21_MinInStack {
    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(4);
        minStack.push(2);
        minStack.push(1);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(1);
    }

    public static class MinStack {
        private Stack<Integer> dataStack;

        private Stack<Integer> minStack;//存放最小值的栈

        private int minNum;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int num) {
            if (dataStack.size() == 0) {
                minNum = num;
            }
            dataStack.push(num);
            if (minNum > num) {
                minNum = num;
            }
            minStack.push(minNum);
        }

        public Integer pop() {
            System.out.println("最小值" + minStack.pop());
            return dataStack.pop();
        }

    }
}
