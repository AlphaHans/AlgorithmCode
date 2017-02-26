package com.hans.offer;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Hans on 17/2/24.
 * 最小的K个数
 * <p>
 * 思路一:
 * 利用快排,时间复杂度 O(nlogn);
 * <p>
 * 思路二:
 * {@link _29_FindMoreThanHalfNum}扩展思路,当pivot==k-1的时候,说明他的左边都是比k-1小的。(虽然不是有序的) 时间复杂度为O(n)
 * 注意其不一定有序
 * <p>
 * 思路三:
 * 海量数据解法(分段加载
 * 1.创建一个大小为K的容器
 * 2.当容器未满事后,直接装入数字;若满,则想办法替换出最大的数
 * 3.但一次遍历完成之后,那么最终还有容器内的数则为最小的K个数
 * <p>
 * 时间复杂度:
 * 如果用一个二叉树来实现这个数据容器，那么我们能在O（logk）时间内实现这三步操作。
 * 因此对于n个输入数字而言，总的时间效率就是O（nlogk）。
 */
public class _30_KLeastNumbers {


    public static void main(String args[]) {
        int datas[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11, 8, 8, 8, 8, 8};

//        findKLeastNumByPartition(data, 3);
//        System.out.println(Arrays.toString(data));

        Set<Integer> container = findKLeastNumBySet(datas, 3);
        for (Integer i : container) {
            System.out.print(i + " ");
        }
    }

    //----思路二:-----------------------------------
    //借用TreeSet 第一位为最大的思想 进行快速移除
    private static Set<Integer> findKLeastNumBySet(int[] datas, int k) {
        Set<Integer> container = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int data : datas) {
            if (container.size() == k) {
                Integer i = container.iterator().next();
                if (i > data) {
                    container.remove(i);
                    container.add(data);
                }
            } else {
                container.add(data);
            }
        }
        return container;
    }

    //-----------思路一----------------------------
    private static void findKLeastNumByPartition(int[] data, int k) {
        int start = 0;
        int end = data.length - 1;
        int pivot = partition(data, start, end);
        while (pivot != k) {
            if (pivot > k) {
                end = pivot - 1;
                pivot = partition(data, start, end);
            } else {
                start = pivot + 1;
                pivot = partition(data, start, end);
            }
        }
    }

    private static int partition(int[] data, int start, int end) {
        if (start == end) return start;
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (left < right && data[left] <= data[end]) {
                left++;
            }
            while (left < right && data[right] >= data[end]) {
                right--;
            }
            swap(data, left, right);
        }
        if (data[left] > data[end]) {
            swap(data, left, end);
        } else {
            left++;
        }
        return left;
    }

    private static void swap(int[] data, int left, int right) {
        if (left != right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }
}
