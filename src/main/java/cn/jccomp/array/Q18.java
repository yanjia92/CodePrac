package cn.jccomp.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by bitbook on 7/22/18.
 */
public class Q18 {

    private static List<List<Integer>> innerSearch(int[] nums, int begin, int end, int target, int count) {
        // nums 已排序数组
        // begin 开始下标
        // end 结束下标，不包括end
        // 在nums数组[begin, end-1]的范围内，找出count个值，其和等于target
        // 返回的是对应元素的下标
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (count == 1) {
            for (int i = begin; i != end; i++) {
                if (nums[i] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(Integer.valueOf(i));
                    results.add(result);
                }
            }
            return results;
        }

        // more than one number
        for (int i = begin; i != end; ++i) {
            if (nums[i] <= target) {
                List<List<Integer>> subResult = innerSearch(nums, i + 1, end, target - nums[i], count - 1);
                for (List<Integer> result : subResult) {
                    result.add(0, i);
                    results.add(result);
                }
            }
        }
        return results;
    }

    public static List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> integers = new ArrayList<>();
        for (int num : nums) {
            integers.add(num);
        }
        Set<Integer> integerSet = new HashSet<>(integers);
        Integer[] arr = new Integer[0];
        Integer[] noDupNums = integerSet.toArray(new Integer[0]);
        int[] noDupArray = new int[noDupNums.length];
        int i = 0;
        for (Integer integer : noDupNums) {
            noDupArray[i++] = integer;
        }
        List<List<Integer>> elemLists = new ArrayList<>();
        List<List<Integer>> indexLists = innerSearch(noDupArray, 0, noDupArray.length, target, 4);
        for (List<Integer> indexList : indexLists) {
            List<Integer> elemList = new ArrayList<>();
            for (Integer index : indexList) {
                elemList.add(nums[index]);
            }
            elemLists.add(elemList);
        }
        return elemLists;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        System.out.println(solution(nums, target));
    }
}
