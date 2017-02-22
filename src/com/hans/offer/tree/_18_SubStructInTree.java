package com.hans.offer.tree;

/**
 * Created by Hans on 17/2/21.
 * 是否为主树的子结构
 */
public class _18_SubStructInTree {


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

        TreeNode tree2 = new TreeNode();
        tree2.value = 8;
        TreeNode t2l = new TreeNode();
        t2l.value = 9;
        TreeNode t2r = new TreeNode();
        t2r.value = 2;
        tree2.left = t2l;
        tree2.right = t2r;

        System.out.println(hasSubTree(tree1, tree2));
    }

    private static boolean hasSubTree(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null) return false;
        boolean isHas = false;
        if (tree1.value == tree2.value) {//找到根节点
            isHas = isSubTree(tree1, tree2);
        }
        if (!isHas) isHas = hasSubTree(tree1.left, tree2);
        if (!isHas) isHas = hasSubTree(tree1.right, tree2);
        return isHas;
    }

    private static boolean isSubTree(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) return true;//说明tree2 已经比较到完了
        if (tree1 == null) return false;
        if (tree1.value != tree2.value) return false;

        return isSubTree(tree1.left, tree2.left) && isSubTree(tree1.right, tree2.right);
    }
}
