package com.hans.offer.node;

/**
 * Created by Hans on 17/2/20.
 * 在O(1)时间删除某一个结点
 */
public class _13_DeleteNodeList {

    public static void main(String[] args) {
        Node head = new Node();
        head.value = 0;
        head.next = null;
        Node deletedNode = null;
        Node deletedNode2 = null;
        Node temp = head;
        for (int i = 1; i < 10; i++) {
            Node next = new Node();
            if (i == 3) {
                deletedNode = next;
            }
            if (i == 9) {
                deletedNode2 = next;
            }
            next.value = i;
            temp.next = next;
            temp = next;
        }

        deleteNode(head, deletedNode);
        printNode(head);
        deleteNode(head, deletedNode2);
        printNode(head);
    }

    private static void printNode(Node head) {
        Node next = head;
        while (next != null) {
            System.out.print(next.value);
            next = next.next;
        }
        System.out.println();
    }

    private static void deleteNode(Node head, Node deletedNode) {
        if (deletedNode.next == null) {//说明是最后一个结点,时间是O(n)
            Node before = head;
            Node next = head.next;
            while (next.next != null) {
                before = next;
                next = next.next;
            }
            //如果next.next是null的话,说明
            before.next = null;
        } else {
            Node next = deletedNode.next;
            if (next != null) {
                deletedNode.value = next.value;
                deletedNode.next = next.next;
            }
        }
    }
}
