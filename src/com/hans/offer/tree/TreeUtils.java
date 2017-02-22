package com.hans.offer.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Hans on 17/2/9.
 */
public class TreeUtils {
    static Queue<TreeNode> queue = new ArrayDeque<>();

    public static void print(TreeNode node) {
        if (node != null)
            queue.add(node);
        while (queue.size() != 0) {
            TreeNode node1 = queue.remove();
            System.out.println(node1.value);
            if (node1.left != null)
                queue.add(node1.left);
            if (node1.right != null)
                queue.add(node1.right);
        }
    }

    public static TreeNode makeTree() {
        TreeNode root = new TreeNode();
        root.value = 10;
        TreeNode left = new TreeNode();
        left.value = 6;
        TreeNode right = new TreeNode();
        right.value = 14;
        root.left = left;
        root.right = right;

        TreeNode ll = new TreeNode();
        ll.value = 4;
        TreeNode lr = new TreeNode();
        lr.value = 8;
        left.left = ll;
        left.right = lr;

        TreeNode rl = new TreeNode();
        rl.value = 12;
        TreeNode rr = new TreeNode();
        rr.value = 16;
        right.left = rl;
        right.right = rr;


        TreeNode lll = new TreeNode();
        lll.value = 3;
        TreeNode llr = new TreeNode();
        llr.value = 6;
        ll.left = lll;
        ll.right = llr;

        return root;
    }
}
