package com.hans.offer;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/27.
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 */
public class _42_2_LeftRotateString {


    public static void main(String args[]) {
        String str = "abcdefg";
        char[] chars = str.toCharArray();
        leftRotate(chars, 2);
        System.out.println(Arrays.toString(chars));
    }

    private static void leftRotate(char[] chars, int moveLength) {
        for (int i = 0; i < moveLength; i++) {
            char temp = chars[0];
            int j = 0;
            for (; j + 1 < chars.length; j++) {
                chars[j] = chars[j + 1];
            }
            chars[chars.length - 1] = temp;
        }
    }
}
