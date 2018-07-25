package cn.jccomp.utils;

import cn.jccomp.binarytree.GTreeNode;
import cn.jccomp.binarytree.TreeNode;

import java.io.ObjectInputStream;

/**
 * Created by bitbook on 2/24/18.
 */
public class BinaryTreeUtil {
    public static TreeNode randomTree() {
        //          5
        //        3    7
        //      10 11 16 19
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(7);
        TreeNode l11 = new TreeNode(10);
        TreeNode l12 = new TreeNode(11);
        TreeNode r11 = new TreeNode(16);
        TreeNode r12 = new TreeNode(19);
        root.left = l1;
        root.right = r1;
        l1.left = l11;
        l1.right = l12;
        r1.left = r11;
        r1.right = r12;
        return root;
    }


    public static TreeNode randomBST() {
        TreeNode root = new TreeNode(10);
        TreeNode l1 = new TreeNode(6);
        TreeNode r1 = new TreeNode(14);
        TreeNode l11 = new TreeNode(4);
        TreeNode l12 = new TreeNode(8);
        TreeNode r11 = new TreeNode(12);
        TreeNode r12 = new TreeNode(16);
        root.left = l1;
        root.right = r1;
        l1.left = l11;
        l1.right = l12;
        r1.left = r11;
        r1.right = r12;
        return root;
    }


    // 构造完全二叉树
    // from层次遍历结果
    // array：层次遍历结果数组
    // rootIndex，所构造的树的跟节点对应的index in array
    public static <T extends Comparable<?>> GTreeNode<T> fromHierTraversal(Object[] array, int rootIndex) {
        if (rootIndex >= array.length) {
            return null;
        }
        T data = (T)array[rootIndex];
        GTreeNode<T> root = new GTreeNode<T>(data);
        int left = 2*rootIndex+1;
        int right = 2*rootIndex+2;
        root.left = fromHierTraversal(array, left);
        root.right = fromHierTraversal(array, right);
        return root;
    }
}
