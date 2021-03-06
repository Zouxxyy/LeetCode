/*
面试题14- I. 剪绳子

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58

 */

/*
笔记：

拆成 2 和 3 的乘积时最大
 */

package com.zouxxyy;

public class Solution14_1 {
    public int cuttingRopeOld(int n) {
        int[] max = new int[n + 1];
        max[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2 ; j++) {
                int temp = j * Math.max(max[i -j], i - j);
                if (temp > max[i])
                    max[i] = temp;
            }
        }
        return max[n];
    }

    public int cuttingRope(int n) {

        if (n <= 3) return n - 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }
}
