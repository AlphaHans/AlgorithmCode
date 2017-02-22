package com.hans.offer.sort.insert;

/**
 * Created by Hans on 17/2/9.
 * 直接插入排序是针对已经排序的序列,插入一个新的值的排序。
 */
public class InsertSort {
    /**
     * 1.假定或不假定原始序列都可以（详见1-2区别
     * 2.将第i位与第i位之前的有序数列进行比较，找到i位所应该处于的位置，设为x
     * 3.将x-i的部分整体向后移动1位
     * 4.将x位的值，赋值为第i位的值
     * 5.重复2-4
     *
     * @param data
     * @return
     */
    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {//需要遍历整条序列
            for (int j = 0; j < i; j++) {//遍历已经排序好的序列
                int dis = data[i] - data[j];
                int temp = data[i];
                if (dis < 0) {////如果小于那么则需要整体后移动;如果大于的话 那么直接跳去下一个
                    for (int k = i; k > j; k--) {
                        data[k] = data[k - 1];
                    }
                    data[j] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 1.不假定0号位初始化为有序序列，即一开始没有原始序列。
     * 2.将第i位与第i位之前的**有序数列**形成一个新的序列（不一定有序） （这里就会和思路一的不同，因为即使从0开始，在经历了这步之后就会有一个初始化之后的序列了）
     * 3.然后思路一一样，进行“向低位冒泡”
     * 4.重复2-3
     *
     * @param data
     * @return
     */
    public static int[] sortAdv(int[] data) {
        for (int i = 0; i < data.length; i++) {//需要遍历整条序列 这里-1是防止j数组越界
            //边比较边移动
            for (int j = i + 1; j > 0; j--) {
                //防止数组越界
                if (j >= data.length || data[j - 1] < data[j]) break;//如果大于,则不需要排序了。 直接放在有序数列末尾即可
                //两两互换,小的往下走
                int temp = data[j];
                data[j] = data[j - 1];
                data[j - 1] = temp;
            }
        }
        return data;
    }

    /**
     * 最简洁的最优解法:利用冒泡的思想
     * <p>
     * 1.假定**第0位数字**组成**原始的有序数列**（符合插排思想）
     * 2.将**第**i位与**第i位之前（不包括i）**的数列进行比较（在算法体现为：第二个for循环从1号开始，这是第1位和第0位组成的数列进行比较
     * 3.若小于则两两交换，大的在后，小的在前；如大于，则什么都不发生 （可以理解成一个向低位的冒泡）
     * 4.重复2-3
     * <p>
     * <p>
     * 实际上2-3可以理解成(这样子的话对于i从1开始则没有要求,即i可以等于0:
     * 2.讲i位放到有序数列的末端,形成一个新的数列
     * 3.然后进行一个向前的冒泡(即小的不断往前冒泡)
     *
     * @param data
     * @return
     */
    public static int[] sortAdv2(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j - 1] > data[j]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
        return data;
    }
}
