package com.hans.offer.node;

/**
 * Created by Hans on 17/2/20.
 */
public class _15_02_MiddleNode {
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
        Node node = getMiddleNode(head);
        System.out.println(node.value);
    }

    private static Node getMiddleNode(Node head) {
        Node fNode = head;
        Node sNode = head;
        while (sNode != null) {
            sNode = sNode.next;
            if (sNode != null) {
                sNode = sNode.next;//第二个Node走两步一次
//                if (sNode != null)//有这个条件 则偶数时 则取前面(如0-9 取4) 如果注释该条件 则取后面(如0-9 取5)
                fNode = fNode.next;
            }
        }
        return fNode;
    }
}
