/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用

 */

package com.zouxxyy;

import java.util.Stack;

public class Solution09 {
    class CQueue {

        private final Stack<Integer> stackPut;
        private final Stack<Integer> stackGet;

        public CQueue() {
            stackPut = new Stack<>();
            stackGet = new Stack<>();
        }

        public void appendTail(int value) {
            stackPut.add(value);
        }

        public int deleteHead() {
            if (stackGet.empty()) {
                while (!stackPut.empty())
                    stackGet.add(stackPut.pop());
            }

            return stackGet.empty() ? -1 : stackGet.pop();
        }
    }
}