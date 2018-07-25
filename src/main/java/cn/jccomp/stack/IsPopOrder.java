package cn.jccomp.stack;

import java.util.*;

/**
 * Created by bitbook on 2/26/18.
 * 判断一个序列是否是栈的弹出序列
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] in, int[] out) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        // put all values of out into queue
        for (int i : out) {
            queue.offer(i);
        }
        for (int i : in) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == queue.peek()) {
                stack.pop();
                queue.poll();
            }
        }
        return stack.isEmpty();
    }
}
