package com.hans.offer.node;

/**
 * Created by Hans on 17/2/20.
 * 合并两个有序的链表
 */
public class _17_MergeSortedNodeList {
    public static void main(String args[]) {
        Node head1 = new Node();
        head1.value = 0;
        head1.next = null;
        Node temp = head1;
        for (int i = 1; i < 10; i++) {
            Node next = new Node();
            next.value = i;
            temp.next = next;
            temp = next;
        }

        Node head2 = new Node();
        head2.value = 9;
        head2.next = null;
        Node temp2 = head2;
        for (int i = 10; i < 20; i++) {
            Node next = new Node();
            next.value = (int) (i / 1.2);
            temp2.next = next;
            temp2 = next;
        }

//        printNode(mergeList(head1, head2));
        printNode(mergeListRecursion(head1, head2));
    }

    /**
     * 递归实现
     * 思想是:
     * 前一个的下一个 是下次一个较小的一个
     * @param head1
     * @param head2
     * @return
     */
    private static Node mergeListRecursion(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node pre = null;
        if (head1.value < head2.value) {
            pre = head1;
            pre.next = mergeListRecursion(head1.next, head2);
        } else {
            pre = head2;
            pre.next = mergeListRecursion(head1, head2.next);
        }
        return pre;
    }

    private static Node mergeList(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node newHead = null;
        Node currentNode = null;
        Node fNode = head1;
        Node sNode = head2;
        //确定头
        if (fNode.value <= sNode.value) {
            newHead = fNode;
            currentNode = fNode;
            fNode = fNode.next;
        } else {
            newHead = sNode;
            currentNode = sNode;
            sNode = sNode.next;
        }

        while (true) {
            if (fNode == null && sNode == null) {
                break;
            } else if (fNode == null && sNode != null) {//第一个链表已经拼完了
                while (sNode != null) {
                    currentNode.next = sNode;
                    currentNode = sNode;
                    sNode = sNode.next;
                }
            } else if (fNode != null && sNode == null) {//第二个链表已经拼完了
                while (fNode != null) {
                    currentNode.next = fNode;
                    currentNode = fNode;
                    fNode = fNode.next;
                }
            } else {//两个链表之间比较大小
                if (fNode.value <= sNode.value) {
                    currentNode.next = fNode;
                    currentNode = fNode;
                    fNode = fNode.next;
                } else {
                    currentNode.next = sNode;
                    currentNode = sNode;
                    sNode = sNode.next;
                }
            }
        }
        return newHead;
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
