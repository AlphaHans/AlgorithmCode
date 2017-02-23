package com.hans.offer.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Hans on 17/2/9.
 */
public class ForReadTest {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.makeTree();
//        printFirst(root);
//        printMiddle(root);
//        printLast(root);
        printLayer(root);
    }
    //--------------------------------------层次遍历--------------------------------

    private static void printLayer(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);//将第一个加入
        while (queue.size() != 0) {
            TreeNode parent = queue.poll();
            printValue(parent);
            if (parent.left != null) {
                queue.add(parent.left);
            }
            if (parent.right != null) {
                queue.add(parent.right);
            }
        }
    }


    //--------------------------------------后序遍历--------------------------------
    private static void printLast(TreeNode root) {
        if (root == null) {
            return;
        }
        printLast(root.left);
        printLast(root.right);
        printValue(root);
    }

    //---------------------------------------中序遍历-------------------------------

    public static void printMiddle(TreeNode root) {
        if (root == null) {
            return;
        }
        printMiddle(root.left);
        printValue(root);
        printMiddle(root.right);
    }

    //---------------------------------------前序遍历-------------------------------

    /**
     * 前序遍历 先访问根节点,然后左,然后右
     *
     * @param root
     */
    public static void printFirst(TreeNode root) {
        if (root == null) {
            return;
        }
        printValue(root);
        printFirst(root.left);
        printFirst(root.right);
    }

    public static void printValue(TreeNode node) {
        if (node == null) return;
        System.out.println(node.value);
    }
}
