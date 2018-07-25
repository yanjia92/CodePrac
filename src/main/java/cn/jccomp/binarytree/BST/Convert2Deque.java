package cn.jccomp.binarytree.BST;

import cn.jccomp.binarytree.GTreeNode;
import cn.jccomp.utils.BTreePrinter;
import cn.jccomp.utils.BinaryTreeUtil;

import java.text.MessageFormat;

/**
 * Created by bitbook on 3/7/18.
 * 将一棵BST转化为双向链表
 */
public class Convert2Deque {
    public static GTreeNode<Integer> convert(GTreeNode<Integer> root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        // 递归将左右子树转化为双向链表
        GTreeNode left = rightMost(convert(root.left));
        GTreeNode right = leftMost(convert(root.right));

        if (left != null)
            left.right = root;
        if (right != null)
            right.left = root;
        root.left = left;
        root.right = right;

        return root;
    }

    public static <T extends Comparable<?>> GTreeNode<T> rightMost(GTreeNode<T> root) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static <T extends Comparable<?>> GTreeNode<T> leftMost(GTreeNode<T> root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int dataNumber = 6;
        Integer datas[] = new Integer[dataNumber];
        for (int i = 0; i != dataNumber; i++) {
            datas[i] = i;
        }
        GTreeNode<Integer> root = BinaryTreeUtil.fromHierTraversal(datas, 0);
        BTreePrinter.printNode(root);
        int height = BTreePrinter.maxLevel(root);
        GTreeNode<Integer> head = convert(root);
        head = leftMost(head);
        while (head != null) {
            System.out.print(MessageFormat.format("{0} ", head.data));
            head = head.right;
        }
        System.out.println("");
    }
}
