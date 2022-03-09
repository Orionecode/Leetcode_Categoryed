package 位运算;

import java.util.Arrays;

/**
 * @Author YixiaoZeng
 * @Date 2022/3/6 20:08
 * @Filename 位运算.Solution338
 */

/* 338. 比特位计数
        给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。*/

public class Solution338 {
    // 方法一：Brian Kernighan Kernighan 算法
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    // 利用 Brian Kernighan 算法，可以在一定程度上进一步提升计算速度。
    // Brian Kernighan 算法的原理是：对于任意整数x，令x = x & (x - 1);
    // 该运算将，的二进制表示的最后一个1变成0，重复该操作，直到，变成 0，则操作次数即为的「一比特数」
    public static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x = x & (x - 1);
            ones++;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
