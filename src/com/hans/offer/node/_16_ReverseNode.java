package com.hans.offer.node;

/**
 * Created by Hans on 17/2/20.
 * 反转链表
 * 1.递归实现
 * 2.while循环实现
 */
public class _16_ReverseNode {
    public static void main(String args[]) {
        Node head = new Node();
        head.value = 0;
        head.next = null;

        Node temp = head;
        for (int i = 1; i < 10; i++) {
            Node next = new Node();
            next.value = i;
            temp.next = next;
            temp = next;
        }
//        reverseNode(head);
//        System.out.println(newHead.value);
//        printNode(newHead);

//        printNode(reverseNode2(head));
    }


    //循环写法
    private static Node reverseNode2(Node head) {
        Node pre = null;
        Node node = head;
        Node newHead = null;
        while (node != null) {
            Node next = node.next;
            if (next == null) newHead = node;
            node.next = pre;
            pre = node;
            node = next;
        }
        return newHead;
    }

    //----------------------------------------------以下是递归写法
    private static Node reverseNode(Node head) {
        doReverse(null, head);//头的前一个是null
        return newHead;
    }

    private static Node newHead = null;

    private static void doReverse(Node pre, Node next) {
        if (next == null) {
            newHead = pre;
            return;
        }
        doReverse(next, next.next);
        next.next = pre;
    }

    private static void printNode(Node head) {
        Node next = head;
        while (next != null) {
            System.out.print(next.value);
            next = next.next;
        }
        System.out.println();
    }
}
