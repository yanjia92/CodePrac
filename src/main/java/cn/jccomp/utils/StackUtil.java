package cn.jccomp.utils;

import cn.jccomp.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by bitbook on 2/26/18.
 */
public class StackUtil {
    public static void printStack(Deque<TreeNode> stack) {
        Deque<TreeNode> copied = new ArrayDeque<TreeNode>(stack);
        while (copied.size() != 0) {
            System.out.println(copied.pollFirst() + " ");
        }
        System.out.println("==========");
    }
}
