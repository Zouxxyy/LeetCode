package com.zouxxyy.c07;

/*
739. 每日温度
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */

/*
思路：

学习单调栈
 */

import java.util.*;

/**
 * @author zxy
 */
public class Solution39 {

    public int[] dailyTemperatures(int[] T) {

        // 单调栈：栈底到栈顶由大到小，用于存放还未找到更高温度的索引（索引对应的值由小到大）
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {

            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }

            stack.push(i);
        }

        return res;
    }

}
