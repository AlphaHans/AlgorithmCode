package com.hans.offer;

/**
 * Created by Hans on 17/2/26.
 * 题目：输入两个链表，找出它们的第一个公共结点。
 * <p>
 * 题意解读:即最终会形成一个Y字
 * <p>
 * 思路一:
 * O(n^2)解法,两次遍历
 * <p>
 * 思路二:
 * 利用栈(链表的倒序输出)  从后往前遍历,最后一个相同节点的就是 他们第一个公共节点。
 * 空间换时间。 最好情况O(max[note1,note2]) 最差情况是O(2*min[note1,note2])
 * <p>
 * 思路三:
 * 从思路二改进,如果能够知道 链表之间相差的距离。 那么就可以让第一个先走几步,然后再开始正向遍历
 * 最好情况O(1) 最差情况是O(min[note1,note2])
 *
 */
public class _37_FirstSameNodeInList {
}
