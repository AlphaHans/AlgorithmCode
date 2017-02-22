package com.hans.offer;

/**
 * Created by Hans on 17/2/20.
 * 数值的整次方
 */
public class _11_Power {

    public static void main(String args[]) {
//        System.out.println(Integer.toBinaryString(14));
//        System.out.println(Double.toHexString(0.5f));
//        System.out.println((0x1 & 14) == 1);
//        System.out.println(0.0 == 0.0);
        long nanaTime = System.nanoTime();
        System.out.println(power(2, -100));
        System.out.println(System.nanoTime() - nanaTime);
        nanaTime = System.nanoTime();
        System.out.println(power2(2, -100));
        System.out.println(System.nanoTime() - nanaTime);
    }


    public static double power(double base, int exponent) {
        if (base == 0.0) return 0.0;
        if (exponent == 0) return 1.0;
        double absExponent = exponent < 0 ? -exponent : exponent;
        double result = 1.0;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

    /**
     * 加速版
     * @param base
     * @param exponent
     * @return
     */
    public static double power2(double base, int exponent) {
        if (base == 0.0) return 0.0;
        if (exponent == 0) return 1.0;
        int absExponent = exponent < 0 ? -exponent : exponent;

        double result = power2(base, absExponent >> 1);
        result *= result;

        if ((absExponent & 0x1) == 1) {//说明是奇数,需要再一次
            result *= base;
        }
        if (exponent < 0)
            result = 1 / result;
        return result;
    }
}
