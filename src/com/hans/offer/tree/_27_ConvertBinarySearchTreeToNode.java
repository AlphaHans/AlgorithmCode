package com.hans.offer.tree;

/**
 * Created by Hans on 17/2/23.
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。比如输入图4.12中左边的二叉搜索树，则输出转换之后的排序双向链表。
 * 例子:
 * 10
 * 6      14
 * 4   8  12   16    ---》  4 6 8 10 12 14 16
 * <p>
 * 思路:
 * 思路1(不符合题目中不能创建新节点的要求):  由数组上面可以看出这是一个中序遍历的结果,可以将数拿出来,重新简历一个双向链表
 * 思路2:
 * 1.首先我们可以看成是有序数列的拼接
 * 2.中序遍历到最左节点, 然后可以利用"插入排序思想的简化版",即前面是有序数列,使用一个TreeNode标记最后一个节点
 * 3.以此递归下去
 *
 * 如:(一个认识:实际上parent还是parent.left还是parent.right 对于此题来说都没有特别之处,当做普通节点即可。 关系是和有序数列的最后一个lastNode有关联)
 * 1.parent.value = 4 , lastNode = null
 * 2.parent.left = lastNode lastNode = parent;
 * 3.然后由于中序遍历回到parent = parent.parent (即parent.value = 6)
 * 4.重复2 (此时的parent.value=6,此时的lastNode已经替换为value=4的那个)
 * 6.由于中序遍历到了parent.right (parent.right.value = 8)
 * 7.重复2
 */
public class _27_ConvertBinarySearchTreeToNode {


    public static void main(String args[]) {
        TreeNode root = makeTree();

        root = convertToNodeList(root);
        printNodeList(root);
    }

    private static TreeNode convertToNodeList(TreeNode root) {
        convert(root);
        TreeNode head = lastNode;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static void printNodeList(TreeNode root) {
        TreeNode next = root;
        while (next != null) {
            System.out.println("我:" + next.value + " 左:" + (next.left == null ? "空" : next.left.value) + " 右:" + (next.right == null ? "空" : next.right.value));
            next = next.right;
        }
    }

    private static TreeNode lastNode = null;

    /**
     * 详情看注释的例子
     * @param parent
     */
    private static void convert(TreeNode parent) {
        if (parent == null) {
            return;
        }
        if (parent.left != null)
            convert(parent.left);
        parent.left = lastNode;

        if (lastNode != null)
            lastNode.right = parent;

        lastNode = parent;

        if (parent.right != null)
            convert(parent.right);
    }

    public static TreeNode makeTree() {
        TreeNode root = new TreeNode();
        root.value = 10;
        TreeNode l = new TreeNode();
        l.value = 6;
        root.left = l;
        TreeNode r = new TreeNode();
        r.value = 14;
        root.right = r;

        TreeNode ll = new TreeNode();
        ll.value = 4;
        l.left = ll;
        TreeNode lr = new TreeNode();
        lr.value = 8;
        l.right = lr;

        TreeNode rl = new TreeNode();
        rl.value = 12;
        r.left = rl;
        TreeNode rr = new TreeNode();
        rr.value = 16;
        r.right = rr;

        return root;
    }
}
