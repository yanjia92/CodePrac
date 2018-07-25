package cn.jccomp.array;

import java.util.Arrays;

/**
 * Created by bitbook on 7/22/18.
 */
public class Q16 {
    private static int selectedSum(int[] array, int... indexes) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = 0;
        int len = array.length;
        for (int index : indexes) {
            if (index < 0 || index >= len) {
                continue;
            }
            sum += array[index];
        }
        return sum;
    }

    public static int solution(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int result = 0;
        int firstPtr = 0;
        Arrays.sort(nums);
        while (firstPtr <= (len - 3)) {
            int secondPtr, thirdPtr;
            secondPtr = firstPtr + 1;
            thirdPtr = len - 1;
            while (secondPtr < thirdPtr) {
                int tempSum = selectedSum(nums, firstPtr, secondPtr, thirdPtr);
                int tempDiff = Math.abs(tempSum - target);
                if (tempDiff == 0) {
                    return target;
                } else if (tempDiff < diff) {
                    diff = Math.abs(tempSum - target);
                    result = tempSum;
                }
                if (tempSum < target) {
                    secondPtr += 1;
                } else {
                    thirdPtr -= 1;
                }
            }
            firstPtr += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 2, 1, -4};
        int target = 1;
        int result = solution(nums, target);
        System.out.println(result);
    }
}
