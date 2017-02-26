package com.hans.offer;

/**
 * Created by Hans on 17/2/21.
 */
public class _10_01_NumberOf0InBinary {

    public static void main(String args[]) {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(getNumberOf0InBinary(10));

    }


    public static int getNumberOf0InBinary(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) == 0) {
                count++;
            }
            flag = flag << 1;
//            System.out.println(Integer.toBinaryString(flag));
        }
        return count;
    }
}
