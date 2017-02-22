package com.hans.offer;

/**
 * Created by Hans on 17/2/9.
 * 倒序输出链表
 * 方法:
 * 1.借助栈(想到借助栈,就应该想到递归,因为栈本身就可以理解为一个递归
 * 2.递归
 */
public class _05_PrintListReversingly {

    public static void main(String args[]) {
        ListNode head = new ListNode();
        ListNode originalHead = head;
        head.value = 0;
        for (int i = 1; i <= 10; i++) {
            ListNode next = new ListNode();
            next.value = i;
            head = append(head, next);
        }
        printReversingly(originalHead);
    }

    public static ListNode append(ListNode head, ListNode next) {
        head.next = next;
        return next;
    }

    public static void printReversingly(ListNode node) {
        if (node != null) {
            printReversingly(node.next);
            System.out.println(node.value);
        }
    }

    public static class ListNode {
        public ListNode next;
        public int value;

        @Override
        public String toString() {
            return "ListNode{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }
    }
}
