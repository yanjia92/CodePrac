package cn.jccomp.binarytree.BST;

import java.util.Arrays;

/**
 * Created by bitbook on 2/26/18.
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=2
 */
public class VerifySequenceOfBST {
    // 判断一个序列是否是一棵BST的后序遍历序列
    public static boolean verify(int[] sequence) {
        print("verify " + Arrays.toString(sequence));
        if (sequence == null || (sequence != null && sequence.length <= 1)) {
            print("result: true");
            return true;
        }
        // get root
        int length = sequence.length;
        int root = sequence[length-1];

        // find first element's index > root
        int idx = partition(sequence, root);
        if (idx < 0 || idx >= length) {
            print("index wrong: " + idx);
            return false;
        }
        print("partition: " + idx);
        if (idx == 0 || idx == length-1) {
            // 没有左子树或者没有右子树
            return verify(Arrays.copyOfRange(sequence, 0, length-1));
        } else if (sequence[idx-1] < root && sequence[idx] > root) {
            // 分别获取左右子树序列
            int[] left = Arrays.copyOfRange(sequence, 0, idx);
            int[] right = Arrays.copyOfRange(sequence, idx, length-1);
            return verify(left) && verify(right);
        } else {
            return false;
        }
    }

    // 找到左右子树的分割点 如果分割后的左右子树不满足性质
    // 例如，左子树中的点不是都小于root，则返回-1
    // 否则返回第一个大于等于root的点的index
    // root: the last element of array
    private static int partition(int[] array, int root) {
        int index = -1;
        for (int i = 0; i != array.length; i++) {
            if (array[i] >= root) {
                index = i;
                break;
            }
        }
        print("index: " + index);
        // 验证index确实能将原序列划分为左右子树
        int[] left = Arrays.copyOfRange(array, 0, index);
        int[] right = Arrays.copyOfRange(array, index, array.length-1);
        print("left: " + Arrays.toString(left));
        print("right: " + Arrays.toString(right));
        for (int i : left) {
            if (i > root)
                index = -1;
        }
        for (int i : right) {
            if (i < root)
                index = -1;
        }
        return index;
    }

    private static void print(String message) {
        System.out.println(message);
    }


    public static void main(String[] args) {
        int[] sequence = new int[]{4,8,6,12,16,14,10};
        System.out.println(verify(sequence));
        int[] seq2 = new int[]{12,16,14,10};// 没有左子树
        int[] seq3 = new int[]{4,6,7,5};
        int[] seq4 = new int[]{7, 4, 6, 5};
//        System.out.println(verify(seq4));
    }
}
