package cn.jccomp.binarytree;

import java.util.Comparator;

/**
 * Created by bitbook on 3/7/18.
 * 泛型TreeNode
 * ?: 泛型中的类型通配符
 */
public class GTreeNode<T extends Comparable<?>> {
    public GTreeNode<T> left, right;
    public T data;

    public GTreeNode(T data) {
        this.data = data;
    }
}
