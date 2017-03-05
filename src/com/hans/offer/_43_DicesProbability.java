package com.hans.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hans on 17/2/28.
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 解析:
 * 1.统计所有点数
 * 2.再去求概率
 * <p>
 * 思路1:
 * 递归统计
 *
 * 思路2 for循环
 */
public class _43_DicesProbability {
    static Map<Integer, Integer> countMap = new HashMap<>();

    public static void main(String args[]) {
//        getAllDicesProbabilityCountReverse(6);
        System.out.println(countMap.toString());
    }


    public static void getAllDicesProbabilityCountReverse(int count) {
        //简化写法
        getResult(0, 0, count);
    }

    private static void getResult(int value, int currentCount, int totalCount) {
        if (currentCount == totalCount) {
            Integer times = countMap.get(value);
            if (times == null) {
                countMap.put(value, 1);
            } else {
                countMap.put(value, ++times);
            }
        } else {
            currentCount++;
            for (int i = 1; i < 7; i++) {
                getResult(value + i, currentCount, totalCount);
            }
        }
    }
}
