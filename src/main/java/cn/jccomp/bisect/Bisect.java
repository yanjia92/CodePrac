package cn.jccomp.bisect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by bitbook on 3/22/18.
 */
public class Bisect {
    static Logger logger = LoggerFactory.getLogger(Bisect.class);

    /**
     *
     * @param arr sorted array ［1， 5， 10， 20， 50， 100］
     * @param val
     * @return 找到该元素所在数组的下标，如不存在val,则返回数据应该插入的位置
     * 算法思路借鉴：https://www.zhihu.com/question/36132386中"胖胖"的回答
     */
    public static int bisect(int arr[], int val) {
        int begin = 0;
        int end= arr.length-1;
        int mid;
        while (begin <= end) { // 搜索空间为不空
//            mid = (begin+end)/2; 会溢出，即如果begin和end均是很大的数字，求和会溢出。
            mid = begin + (end - begin)/2;
            if (val > arr[mid]) begin = mid+1;
            if (val < arr[mid]) end = mid-1;
            if (val == arr[mid]) return mid;
        }
        return begin;
    }

    public static void main(String[] args) {
        int arr[] = {1,5,10,20,50,100};
        int missing[] = {-1, 3, 6, 15, 25, 99, 101};
        int ans[] = {0, 1, 2, 3, 4, 5, 6};
        for (int idx = 0; idx < missing.length; idx++) {
            int i = missing[idx];
            int insertPos = bisect(arr, i);
            assert ans[idx] == insertPos : "val=" + i;
        }
    }
}
