package com.hans.offer.tree;

/**
 * Created by Hans on 17/2/21.
 * 生成镜像的树
 */
public class _19_MirrorTree {


    public static void main(String args[]) {
        TreeNode tree1 = new TreeNode();
        tree1.value = 8;
        TreeNode tl = new TreeNode();
        tl.value = 8;
        TreeNode tr = new TreeNode();
        tr.value = 7;
        tree1.left = tl;
        tree1.right = tr;

        TreeNode tll = new TreeNode();
        tll.value = 9;
        TreeNode tlr = new TreeNode();
        tlr.value = 2;
        tl.left = tll;
        tl.right = tlr;

        TreeNode tlrl = new TreeNode();
        tlrl.value = 4;
        TreeNode tlrr = new TreeNode();
        tlrr.value = 7;
        tlr.left = tlrl;
        tlr.right = tlrr;

        TreeUtils.print(tree1);
        System.out.println();
        mirrorTree(tree1);
        TreeUtils.print(tree1);
    }

    private static void mirrorTree(TreeNode root) {
        if (root == null) return;
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    private static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
