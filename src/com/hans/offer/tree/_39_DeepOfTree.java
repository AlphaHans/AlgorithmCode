package com.hans.offer.tree;


/**
 * Created by Hans on 17/2/26.
 */
public class _39_DeepOfTree {


    public static void main(String args[]) {
        TreeNode root = TreeUtils.makeTree();
        int deep = getDeep(root);
        System.out.println(deep);
    }

    public static int getDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDeep(node.left);
        int right = getDeep(node.right);
        return left > right ? left + 1 : right + 1;
    }
}
