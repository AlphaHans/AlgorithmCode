package com.hans.offer.node;

/**
 * Created by Hans on 17/2/20.
 * 链表中倒数第k个结点
 */
public class _15_KthNodeFromEnd {

    public static void main(String[] args) {
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
        System.out.println(getKthNodeFromEnd(head, 10).value);
    }

    private static Node getKthNodeFromEnd(Node head, int order) {
        Node behind = head;
        Node after = head;
        //先走,保持一定距离
        for (int i = 0; i < order - 1; i++) {
            after = after.next;
            if (after == null) throw new RuntimeException("order大于链表长度");
        }
        while (after.next != null) {
            after = after.next;
            behind = behind.next;
        }
        return behind;
    }




}
