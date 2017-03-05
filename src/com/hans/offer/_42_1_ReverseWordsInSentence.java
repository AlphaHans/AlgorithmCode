package com.hans.offer;

import java.util.Arrays;

/**
 * Created by Hans on 17/2/27.
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 思路
 * 反转整个句子,然后再重新将单词反转
 */
public class _42_1_ReverseWordsInSentence {

    public static void main(String args[]) {
        String str = "I am a student. ";
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));
        reverseStr(chars);
        System.out.println(Arrays.toString(chars));
    }

    private static void reverseStr(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        reverseWordInternal(chars, start, end);

        reverseWord(chars);
    }

    private static void reverseWord(char[] chars) {
        int start = 0;
        int end = start + 1;
        while (start < chars.length && end < chars.length) {
            if (isSpace(chars, start)) {
                while (end < chars.length && !isSpace(chars, end)) {
                    end++;
                }
                int wordStart = start;
                int wordEnd = end - 1;
                reverseWordInternal(chars, wordStart, wordEnd);

                start = wordEnd + 1;
                end = start + 1;
            } else {
                start++;
            }
        }
    }

    private static void reverseWordInternal(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }


    private static void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

    private static boolean isSpace(char[] chars, int pos) {
        return chars[pos] == ' ';
    }
}
