package com.zouxxyy.c08;

/*
861. 翻转矩阵后的得分
有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

返回尽可能高的分数。



示例：

输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39


提示：

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] 是 0 或 1
 */

/**
 * @author zxy
 */
public class Solution61 {

    public int matrixScore(int[][] A) {

        // 思路：贪心

        int res = 0;
        int m = A.length;
        int n = A[0].length;

        // 1. 进行行翻转，可以将第一列全部翻转成 1
        res += m * (1 << (n - 1));

        // 2. 接下对每一列进行分析，让每一列的 1 最多
        for (int j = 1; j < n; j++) {

            int count1 = 0;

            for (int[] ints : A) {
                count1 += ints[0] == 1 ? ints[j] : 1 - ints[j];
            }

            res += Math.max(count1, m - count1) * (1 << (n - 1 - j));

        }

        return res;
    }

}
