package com.hans.offer.node;

/**
 * Created by Hans on 17/2/20.
 * 链表找环
 */
public class _15_01_IsCircleNode {

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
        temp.next = head;//成环


        boolean isCircle = isCircleNode(head);
        System.out.println(isCircle);
    }

    private static boolean isCircleNode(Node head) {
        Node fNode = head;
        Node sNode = head;
        while (true) {
            if (sNode.next == null || sNode.next.next == null) return false;//如果过程中 发现他的下一个是null就直接返回不是环
            sNode = sNode.next.next;
            fNode = fNode.next;
            if (fNode == sNode) return true;
        }
    }
}
