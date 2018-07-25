package cn.jccomp;

import java.util.Stack;

/**
 * Created by bitbook on 2/22/18.
 * 用两个栈实现一个队列
 */
public class QueueWithTwoStacks {
    private  Stack<Integer> stack1;
    private  Stack<Integer> stack2;

    public void push(int v) {
        stack1.push(v);
    }

    public  int pop() throws Exception{
        if (stack1.empty() && stack2.empty()) {
            throw new Exception("queue empty");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
