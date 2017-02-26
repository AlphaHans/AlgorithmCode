package com.hans.offer.tree;

/**
 * Created by Hans on 17/2/26.
 * <p>
 * 判断是否为二叉平衡树(左右节点深度相差不过1)
 * <p>
 * 思路一:
 * 1.利用{@link _39_DeepOfTree} 深度遍历节点左右
 * 2.比较
 * 3.继续往下遍历左右节点,然后重复1
 * <p>
 * 思路二:
 * 1.优化思路一。 思路一需要重复遍历,因为深度计算一次,判断左右是否又一次
 * 2.优化方向,在边遍历深度的同时,判断其左右是否为平衡树
 */
public class _39_02_IsBalanceTree {


    public static void main(String args[]) {
        TreeNode root = TreeUtils.makeTree();
//        root= TreeUtils.makeUnbalanceTree();
        System.out.print(isBalanceTree2(root));
    }

    private static int deep = 0;

    private static boolean isBalanceTree2(TreeNode root) {
        if (root == null) {
            deep = 0;
            return true;
        }
        int left, right;
        boolean leftFlag = isBalanceTree2(root.left);
        left = deep;
        boolean rightFlag = isBalanceTree2(root.right);
        right = deep;
        if (leftFlag && rightFlag) {
            int diff = left - right;
            deep = 1 + (left > right ? left : right);
            return diff >= -1 || diff <= 1;
        }
        return false;
    }

    private static boolean isBalanceTree(TreeNode root) {
        if (root == null) return true;
        int left = _39_DeepOfTree.getDeep(root.left);
        int right = _39_DeepOfTree.getDeep(root.right);
        int diff = left - right;
        if (diff < -1 || diff > 1) return false;
        return isBalanceTree(root.left) && isBalanceTree(root.right);
    }
}
