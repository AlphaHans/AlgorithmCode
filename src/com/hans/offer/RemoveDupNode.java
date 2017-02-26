package com.hans.offer;

import com.hans.offer.node.Node;

/**
 * Created by Hans on 17/2/26.
 */
public class RemoveDupNode {

    public static void main(String args[]) {
        Node node = new Node();
        node.value = 1;

        Node node1 = new Node();
        node1.value = 1;
        node.next = node1;

        Node node2 = new Node();
        node2.value = 2;
        node1.next = node2;

        Node node3 = new Node();
        node3.value = 2;
        node2.next = node3;

        Node node4 = new Node();
        node4.value = 4;
        node3.next = node4;

        Node newNode = removeDupNode(node);
        printNode(newNode);
    }

    private static void printNode(Node newNode) {
        Node temp = newNode;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private static Node removeDupNode(Node node) {
        Node p, q, r, pre, newHead = node;
        pre = node;
        p = node.next;
        while (p != null) {
            q = p;
            boolean isSame = false;
            while (q.next != null) {
                if (q.next.value == p.value) {
                    r = q.next;
                    q.next = r.next;
                    isSame = true;
                } else {
                    q = q.next;
                }
            }
            if (isSame) {
                pre.next = p.next;
                if (pre.value == node.value) {
                    newHead = p.next;
                }
            }
            p = p.next;
        }
        return newHead;
    }
}
