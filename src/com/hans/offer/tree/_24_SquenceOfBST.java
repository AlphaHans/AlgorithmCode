package com.hans.offer.tree;

/**
 * Created by Hans on 17/2/23.
 * 验证一个后续遍历的数组 能否组成二叉查找树(binary search tree)
 * BST特点:
 * 1.左子树的节点,都小于根节点;右子树的节点,都大于根节点
 * 2.左子节点小于父节点,右子节点大于父节点
 */
public class _24_SquenceOfBST {

    public static void main(String args[]) {
        //这个数组是一个 BST树后续遍历的结果。 特点是,最后一位是根节点,数组左边小于根的为左子数,右边为右子树
        int data[] = {5, 7, 6, 9, 11, 10, 8};
        System.out.print(verifyIsBST(data, 0, data.length - 1));
    }

    /**
     * 用于检测每一个数组的每一个小段是否为 BST结构 (从root开始
     *
     * @param data
     * @param start
     * @param end
     * @return
     */
    private static boolean verifyIsBST(int[] data, int start, int end) {
        if (start >= end) return true;

        int root = data[end];
        //找到相对于root的左子树
        int leftPos = 0;
        for (; leftPos < end; leftPos++) {
            if (data[leftPos] > root) {
                break;
            }
        }
        leftPos--;

        //上面定位了左字数,说明剩下的都是右子树,如果有错<root,那说明不是BST
        int rightPos = leftPos + 1;
        for (; rightPos < end; rightPos++) {
            if (data[rightPos] < root) return false;//右侧如果有小于root的,那么则不是
        }

        boolean left = verifyIsBST(data, 0, leftPos);//递归检测
        boolean right = verifyIsBST(data, rightPos, end - 1);//递归检测
        return left && right;
    }
}
