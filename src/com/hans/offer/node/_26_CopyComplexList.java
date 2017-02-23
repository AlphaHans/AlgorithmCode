package com.hans.offer.node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hans on 17/2/23.
 * 复制复杂链表:
 * 例子:
 * 1 2 3 4 5 一个链表
 * 且每个Node可能带有一个sibling指向别的Node。
 * 如:
 * node.value = 1
 * node.next = node2(他的value=2)
 * node.sibling = node5(他的value=5)
 * <p>
 * 三种做法:
 * 1.O(n^2) 先拷贝主干,然后再拷贝sibling
 * 2.O(n) 先拷贝主干,然后再拷贝sibling - 使用HashMap进行优化,减少一层循环。 空间换时间
 * 3.A->A`->B->B`->C->C` 这样拷贝。比较复杂,剑指offer上详解.(分别进行一次循环就完成了,一共两次)
 */
public class _26_CopyComplexList {


    public static void main(String args[]) {
        ComplexNode head = makeComplexList();
//        print(head);
        ComplexNode copyList = copy2(head);
        print(copyList);
    }

    /**
     * 整体思路:
     * 1.先拷贝主干
     * 2.然后拷贝sibling
     * <p>
     * 时间为O(n^2)的解法
     *
     * @param head
     * @return
     */
    private static ComplexNode copy1(ComplexNode head) {
        ComplexNode next = head;
        ComplexNode newHead = null;
        ComplexNode newNext = null;
        //拷贝主干
        while (next != null) {
            ComplexNode node = cloneNode(next);
            if (newHead == null) {
                newHead = node;
                newNext = node;
            } else {
                newNext.next = node;
                newNext = node;
            }
            next = next.next;
        }
        next = head;
        newNext = newHead;
        //拷贝sibling
        while (next != null) {
            if (next.sibling != null) {
                ComplexNode internalLoop = head;
                while (internalLoop != null) {
                    if (internalLoop.sibling != null && internalLoop.sibling.value == next.sibling.value) {
                        newNext.sibling = cloneNode(internalLoop.sibling);
                    }
                    internalLoop = internalLoop.next;
                }
            }
            next = next.next;
            newNext = newNext.next;
        }
        return newHead;
    }


    /**
     * 优化copy1:(空间换时间的做法)
     * 引入hash表结构,不用进行第二个while循环。 提升至O(n)
     * <p>
     * 整体思路:
     * 1.先拷贝主干
     * 2.然后拷贝sibling
     * <p>
     * <p>
     * 时间为O(n)的解法
     *
     * @param head
     * @return
     */
    private static ComplexNode copy2(ComplexNode head) {
        Map<Integer, ComplexNode> hashMap = new HashMap<>();

        ComplexNode next = head;
        ComplexNode newHead = null;
        ComplexNode newNext = null;
        //拷贝主干
        while (next != null) {
            ComplexNode node = cloneNode(next);
            if (newHead == null) {
                newHead = node;
                newNext = node;
            } else {
                newNext.next = node;
                newNext = node;
            }
            hashMap.put(next.value, next);
            next = next.next;
        }
        next = head;
        newNext = newHead;
        //拷贝sibling
        while (next != null) {
            if (next.sibling != null) {
                //引入Hash表 空间换时间
                newNext.sibling = cloneNode(hashMap.get(next.sibling.value));
            }
            next = next.next;
            newNext = newNext.next;
        }
        return newHead;
    }

//    /**
//     * 错误解法:
//     * 虽然 sibling值相同,但是链表不是连接起来的
//     *
//     * @param head
//     * @return
//     */
//    private static ComplexNode copy3(ComplexNode head) {
//        ComplexNode next = head;
//        ComplexNode newHead = null;
//        ComplexNode newNext = null;
//        while (next != null) {
//            ComplexNode newNode = cloneNode(next);
//            ComplexNode newSiblingNode = cloneNode(next.sibling);
//            newNode.sibling = newSiblingNode;
//            if (newHead == null) {
//                newHead = newNode;
//                newNext = newNode;
//            } else {
//                newNext.next = newNode;
//                newNext = newNode;
//            }
//            next = next.next;
//        }
//        return newHead;
//    }

    private static ComplexNode cloneNode(ComplexNode node) {
        if (node == null) return null;
        ComplexNode newNode = new ComplexNode();
        newNode.value = node.value;
        newNode.next = node.next;
        return newNode;
    }

    private static void print(ComplexNode head) {
        ComplexNode next = head;
        while (next != null) {
            System.out.println("当前值为:" + next.value + " sibling值为:" + (next.sibling == null ? "空" : next.sibling.value));
            next = next.next;
        }
    }

    private static ComplexNode makeComplexList() {
        ComplexNode node1 = new ComplexNode();
        node1.value = 1;
        ComplexNode node2 = new ComplexNode();
        node2.value = 2;
        node1.next = node2;
        ComplexNode node3 = new ComplexNode();
        node3.value = 3;
        node2.next = node3;
        ComplexNode node4 = new ComplexNode();
        node4.value = 4;
        node3.next = node4;
        ComplexNode node5 = new ComplexNode();
        node5.value = 5;
        node4.next = node5;
        node5.next = null;

        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        return node1;
    }

    public static class ComplexNode {
        public int value;
        public ComplexNode next;
        public ComplexNode sibling;
    }
}
