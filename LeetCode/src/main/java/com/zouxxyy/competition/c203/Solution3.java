package com.zouxxyy.competition.c203;

/*
5497. 查找大小为 M 的最新分组
给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。

在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。

给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。

返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。



示例 1：

输入：arr = [3,5,1,2,4], m = 1
输出：4
解释：
步骤 1："00100"，由 1 构成的组：["1"]
步骤 2："00101"，由 1 构成的组：["1", "1"]
步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
步骤 4："11101"，由 1 构成的组：["111", "1"]
步骤 5："11111"，由 1 构成的组：["11111"]
存在长度为 1 的一组 1 的最后步骤是步骤 4 。
示例 2：

输入：arr = [3,1,5,4,2], m = 2
输出：-1
解释：
步骤 1："00100"，由 1 构成的组：["1"]
步骤 2："10100"，由 1 构成的组：["1", "1"]
步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
步骤 4："10111"，由 1 构成的组：["1", "111"]
步骤 5："11111"，由 1 构成的组：["11111"]
不管是哪一步骤都无法形成长度为 2 的一组 1 。
示例 3：

输入：arr = [1], m = 1
输出：1
示例 4：

输入：arr = [2,1], m = 2
输出：2


提示：

n == arr.length
1 <= n <= 10^5
1 <= arr[i] <= n
arr 中的所有整数 互不相同
1 <= m <= arr.length
 */

/*
思路：

学习下用指针表示范围的方法（单向链表）
 */

/**
 * @author zxy
 */
public class Solution3 {

    public int findLatestStep(int[] arr, int m) {

        // 段：1 1 1 1 1 1
        // 核心是1个指针定义段：如果是段头就指向段尾，如果是段尾就指向段头，段长度 = abs(link[i] - i) + 1

        // link数组：头尾各有一个空点，所以是大小是 n + 2：_ 1 2 3 4 5 _
        int[] link = new int[arr.length + 2];

        // 段长为 m 的个数
        int cnt = 0;
        int res = -1;

        for (int i = 0; i < arr.length; i++) {

            // 当前坐标
            int x = arr[i];
            // 左段 link
            int l = link[x - 1] != 0 ? link[x - 1] : x;
            // 右段 link
            int r = link[x + 1] != 0 ? link[x + 1] : x;

            // 修改 cnt
            if (x - l == m) {
                cnt--;
            }
            if (r - x == m) {
                cnt--;
            }
            if (r - l + 1 == m) {
                cnt++;
            }
            if (cnt > 0) {
                res = i + 1;
            }

            // 合并段
            link[l] = r;
            link[r] = l;
        }

        return res;
    }

}
