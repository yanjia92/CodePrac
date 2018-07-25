package cn.jccomp.stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.jar.Pack200;

/**
 * Created by bitbook on 2/25/18.
 * 返回当前栈的最小值，O(1)时间复杂度
 */
public class MinStack {
    private int size;
    private Integer[] elements = new Integer[10];
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer min = Integer.MAX_VALUE;

    public void push(int node) {
        ensureCapacity(size+1);
        this.elements[size] = node;
        size++;
        if (node < this.min) {
            this.minStack.push(node);
            this.min = node;
        } else {
            this.minStack.push(this.min);
        }
    }

    public void pop() {
        Integer top = top();
        if (top != null) {
            this.elements[size-1] = null;
            size--;
            minStack.pop();
            min = minStack.peek();
        }
    }

    public Integer top() {
        if (!empty()) {
            if (size >= 1) {
                Integer top = this.elements[size-1];
                return top;
            }
        }
        return null;
    }

    public boolean empty() {
        return size == 0;
    }

    // size: 添加数据后数组应该有的大小
    private void ensureCapacity(int size) {
        int len = this.elements.length;
        if (size > this.elements.length) {
            int newLength = (len*3)/2+1;
            Arrays.copyOf(elements, newLength);
        }
    }
}
