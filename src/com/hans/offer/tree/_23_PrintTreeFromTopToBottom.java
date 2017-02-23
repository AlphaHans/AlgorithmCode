package com.hans.offer.tree;

/**
 * Created by Hans on 17/2/23.
 * 树的层次遍历
 */
public class _23_PrintTreeFromTopToBottom {

    public static void main(String args[]) {
        //借用队列,先进先出
        TreeUtils.print(TreeUtils.makeTree());
    }
}
