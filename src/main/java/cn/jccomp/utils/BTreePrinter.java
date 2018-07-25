package cn.jccomp.utils;


import cn.jccomp.binarytree.GTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bitbook on 3/7/18.
 * copied from https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
 */
public class BTreePrinter {
    public static <T extends Comparable<?>> void printNode(GTreeNode<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<GTreeNode<T>> nodes, int level, int maxLevel) {
        // 思想：层次遍历打印出每一行数据
        // 利用深度控制开头的空格和元素之间的空格以及其他
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1; // 每一行开头的空格
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1; // 每个节点之间的空格数

        BTreePrinter.printWhitespaces(firstSpaces);

        List<GTreeNode<T>> newNodes = new ArrayList<GTreeNode<T>>();
        for (GTreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left); // append to last
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println(""); // 换行

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1); // 等差数列

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    public static <T extends Comparable<?>> int maxLevel(GTreeNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    private static GTreeNode<Integer> test1() {
        GTreeNode<Integer> root = new GTreeNode<Integer>(2);
        GTreeNode<Integer> n11 = new GTreeNode<Integer>(7);
        GTreeNode<Integer> n12 = new GTreeNode<Integer>(5);
        GTreeNode<Integer> n21 = new GTreeNode<Integer>(2);
        GTreeNode<Integer> n22 = new GTreeNode<Integer>(6);
        GTreeNode<Integer> n23 = new GTreeNode<Integer>(3);
        GTreeNode<Integer> n24 = new GTreeNode<Integer>(6);
        GTreeNode<Integer> n31 = new GTreeNode<Integer>(5);
        GTreeNode<Integer> n32 = new GTreeNode<Integer>(8);
        GTreeNode<Integer> n33 = new GTreeNode<Integer>(4);
        GTreeNode<Integer> n34 = new GTreeNode<Integer>(5);
        GTreeNode<Integer> n35 = new GTreeNode<Integer>(8);
        GTreeNode<Integer> n36 = new GTreeNode<Integer>(4);
        GTreeNode<Integer> n37 = new GTreeNode<Integer>(5);
        GTreeNode<Integer> n38 = new GTreeNode<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }
    
    private static GTreeNode<String> ltl() {
        GTreeNode<String> root = new GTreeNode<>("&");
        GTreeNode<String> n11 = new GTreeNode<>("!");
        GTreeNode<String> n12 = new GTreeNode<>("U");
        GTreeNode<String> n21 = new GTreeNode<>("ap1");
        GTreeNode<String> n22 = new GTreeNode<>("");
        GTreeNode<String> n23 = new GTreeNode<>("ap2");
        GTreeNode<String> n24 = new GTreeNode<>("ap3");
        root.left = n11;
        root.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;
        return root;
    } 

    public static void main(String[] args) {
        
        BTreePrinter.printNode(ltl());
    }
}