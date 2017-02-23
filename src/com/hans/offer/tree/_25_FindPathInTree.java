package com.hans.offer.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hans on 17/2/23.
 * 寻找树中和为某一值的路径
 */
public class _25_FindPathInTree {
    private static int REQUEST_SUM = 22;
    private static int totalSum = 0;

    public static void main(String args[]) {
        TreeNode root = makeTree();
        List<TreeNode> path = new ArrayList<>();//理论上应该用栈实现,但是栈无法打印所有节点。 所以用ArrayList模拟栈
        findPath(root, path);
    }

    /**
     * 思路:
     * 1.要求从根开始遍历,那么我们可以考虑是 前序遍历以及层次遍历 排除了后序遍历和中序遍历
     * 2.层次遍历节点之间不存在路径,所以我们只能考虑使用前序遍历
     *
     * @param parent
     * @param path
     */
    private static void findPath(TreeNode parent, List<TreeNode> path) {
        if (parent == null) return;

        path.add(parent);
        totalSum += parent.value;

        if (totalSum == REQUEST_SUM) {
            printPath(path);
//            //如果等于SUM 那么要移除(因为其后续的加起来只会比他大
//            totalSum -= parent.value;
//            path.remove(parent);
        } else {
            findPath(parent.left, path);
            findPath(parent.right, path);
//            //遍历到子节点都为null时,也要移除了,要沿路径返回
//            totalSum -= parent.value;
//            path.remove(parent);
        }
        //if-else中两种起床抽出来的
        totalSum -= parent.value;
        path.remove(parent);
    }

    private static void printPath(List<TreeNode> path) {
        for (TreeNode node : path) {
            System.out.print(node.value + " ");
        }
        System.out.println();
    }

    public static TreeNode makeTree() {
        TreeNode root = new TreeNode();
        root.value = 10;
        TreeNode l = new TreeNode();
        l.value = 5;
        root.left = l;
        TreeNode r = new TreeNode();
        r.value = 12;
        root.right = r;
        TreeNode ll = new TreeNode();
        ll.value = 4;
        l.left = ll;
        TreeNode lr = new TreeNode();
        lr.value = 7;
        l.right = lr;
        return root;
    }
}
