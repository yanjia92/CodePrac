package cn.jccomp;

import java.util.List;

/**
 * Created by bitbook on 3/8/18.
 * 找到一个数组当中个数超过原数组长度一半的元素
 */
public class FindHalf {

    public int find(int[] array) {
        if (array == null || array != null && array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int count = 1, temp = array[0];
        for (int i = 1; i != array.length; ++i) {
            if (count == 0) {
                temp = array[i];
                count = 1;
            } else {
                if (temp != array[i]) {
                    count--;
//                    temp = array[i];
                } else {
                    count++;
                }
            }
        }

        count = 0;
        for (int elem : array) {
            if (temp == elem) {
                count++;
            }
        }
        if (count > array.length/2.0) {
            return temp;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] positive = {1,2,3,4,3,3,3};
        int[] positive1 = {2,2,2,2,2,1,3,4,5};
        int moreThanHalf = new FindHalf().find(positive1);
        System.out.println(moreThanHalf);
    }
}
