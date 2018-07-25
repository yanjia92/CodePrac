package cn.jccomp.binarytree;

import cn.jccomp.utils.BinaryTreeUtil;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by bitbook on 2/26/18.
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=2
 */
public class FindPath {
    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();

    // 树的深度优先遍历
    //            1
    //         2      3
    //      4    5  6   7
    // 深度优先遍历结果: 1 2 4 5 3 6 7
    public static void dfs0(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.addFirst(root);
        while(!stack.isEmpty()) {
            TreeNode top = stack.pollFirst();
            if (top != null) {
                System.out.println(top.val + " ");
                if (top.right != null) stack.addFirst(top.right);
                if (top.left != null) stack.addFirst(top.left);
            } else {
                continue;
            }
        }
    }


    // 树的深度优先遍历
    //          5
    //        3    7
    //      10 11 16 19
    public static void dfs(TreeNode root, int target) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        while(stack.size() > 0) {
            List<TreeNode> list = visit(stack, target); // 统计栈中所有元素之和
            if (list != null) {
                System.out.println(Arrays.toString(list.toArray()));
            }
            TreeNode top = stack.peek();
            while(top != null && (top.right == null || top.rightVisited == true)) {
                stack.pollFirst();
                top = stack.peek();
            }
            if (top == null) {
                break;
            } else if (top.rightVisited == false && top.right != null){
                top.rightVisited = true;
                cur = top.right;
            }
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

    public static List<TreeNode> visit(Deque<TreeNode> stack, int target) {
        // StackUtil.printStack(stack);
        Integer sum = 0;
        for (TreeNode node: stack) {
            sum += node.val;
        }
        if (sum == target) {
            List<TreeNode> result = new ArrayList<>(stack);
            return result;
        }
        return null;
    }

    //          5
    //        3    7
    //      10 11 16 19
    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

    public static void main(String[] args) {
        TreeNode tree= BinaryTreeUtil.randomTree();
//        dfs(tree, 18);
//        dfs0(BinaryTreeUtil.randomTree());
        System.out.println(findPath(tree, 28));
    }
}
