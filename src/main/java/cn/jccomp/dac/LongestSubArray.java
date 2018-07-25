package cn.jccomp.dac;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by bitbook on 3/8/18.
 * 求最长连续子序列
 */
public class LongestSubArray {

    // 找到array的最长子序列的和
    public static int solution(int[] array) {
        if (array == null || array.length <=  0) return 0;
        if (array.length == 1) {
            return array[0];
        }

        int sum;

        // 分治算法
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        int leftSum = solution(left);
        int rightSum = solution(right);

        // 求出第三种情况，当最长子序列横跨左右
        int max = array[mid-1];
        int sumTemp = 0;
        for (int i = mid-1; i>= 0; i--) {
            sumTemp += array[i];
            if (sumTemp > max) {
                max = sumTemp;
            }
        }
        int max1 = array[mid];
        int sumTemp1 = 0;
        for (int i = mid; i != array.length; i++) {
            sumTemp1 += array[i];
            if (sumTemp1 > max1) {
                max1 = sumTemp1;
            }
        }

        int midSum = max + max1;
        sum = leftSum > rightSum ? leftSum : rightSum;
        sum = sum > midSum ? sum : midSum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubArray.solution(new int[]{1,2,3,-1}));
        System.out.println(LongestSubArray.solution(new int[]{-1,-2,-3,-1}));

    }
}
