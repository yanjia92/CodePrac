package cn.jccomp.binarytree;

/**
 * Created by bitbook on 2/24/18.
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public boolean rightVisited = false; // 用于树深度优先遍历时用，false表示当前节点的右节点没有被访问过

    public TreeNode(int v) {val = v;}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
