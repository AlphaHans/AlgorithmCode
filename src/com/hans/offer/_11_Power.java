package com.hans.offer;

/**
 * Created by Hans on 17/2/20.
 * 数值的整次方
 * <p>
 * 思路:
 * 如果是负数,先转为正数去计算。再根据次数exponent 去判断最终是正还是负
 * <p>
 * 思路1: 使用循环,result * = base。 这样会进行很多重复性的计算。 比如 2^6方  需要经过6次循环。 其实可以2^3*2^3 这样只要经过一次 2^3计算,然后再自乘即可
 * <p>
 * 思路2:使用递归 result = power(base,exponent>>1)  result*= result; 这样可以只要O(n/2)即可算出来. 不过要注意奇数的情况要最后再result*=base;
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
     *
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
