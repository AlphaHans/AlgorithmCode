package com.hans.offer.tree.heap;

import com.hans.offer.tree.TreeNode;
import com.hans.offer.tree.TreeUtils;

/**
 * Created by Hans on 17/2/22.
 */
public class BuildHeap {

    public static void main(String args[]) {
        int[] data = {70, 60, 12, 40, 30, 8, 10};
        TreeNode root = buildHeap(data);
        TreeUtils.print(root);
        System.out.println();
    }

    private static TreeNode buildHeap(int[] data) {
        TreeNode root = new TreeNode();
        root.value = data[0];
        buildHeapParent(root, 0, data);
        return root;
    }

    private static void buildHeapParent(TreeNode parent, int pos, int[] data) {
        int left = pos * 2 + 1;
        if (left < data.length) {
            TreeNode leftChild = new TreeNode();
            leftChild.value = data[left];
            parent.left = leftChild;
            buildHeapParent(leftChild, left, data);
        }
        int right = pos * 2 + 2;
        if (right < data.length) {
            TreeNode rightChild = new TreeNode();
            rightChild.value = data[right];
            parent.right = rightChild;
            buildHeapParent(rightChild, right, data);
        }
    }


    private static int floor(double num) {
        if (num >= 0) {
            return (int) num;
        } else {
            num--;
            return (int) num;
        }
    }

    private static void adjustHeap(int[] data, int parentPos) {
        int leftPos = parentPos * 2 + 1;
        int rightPos = parentPos * 2 + 2;
        if (parentPos <= ((data.length - 1) / 2)) {//非叶子节点才调整
            if (leftPos < data.length && rightPos < data.length) {
                if (data[leftPos] > data[rightPos]) {
                    swap(data, leftPos, rightPos);
                    adjustHeap(data, leftPos);
                    adjustHeap(data, rightPos);
                }
            }
            if (leftPos < data.length && data[leftPos] < data[parentPos]) {
                swap(data, leftPos, parentPos);
                adjustHeap(data, leftPos);
            }
        }
    }

    private static void swap(int[] data, int leftPos, int parentPos) {
        int temp = data[leftPos];
        data[leftPos] = data[parentPos];
        data[parentPos] = temp;
    }
}
