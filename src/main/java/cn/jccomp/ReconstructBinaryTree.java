package cn.jccomp;

import java.util.Arrays;

/**
 * Created by bitbook on 2/22/18.
 */
public class ReconstructBinaryTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v) {
            value = v;
        }
    }

    // array不包含重复元素
    // 找到返回index，否则－1
    private int findIndex(int[] array, int target) {
        for (int i = 0; i != array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 根据前序和中序遍历重构
    public TreeNode reconstruct(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i != in.length;i++) {
            if (in[i] == pre[0]) {
                root.left = reconstruct(Arrays.copyOfRange(pre, 1, 1+i), Arrays.copyOfRange(in, 0, i));
                root.right = reconstruct(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }
}
