package cn.jccomp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bitbook on 3/8/18.
 * 全排列算法
 */
public class PermTest {

    // syntax: public/private/protected <type> returnType funcname() {}
    // list: 数列
    // return: 返回list中的所有的元素的一个全排列
    public  <T extends Comparable<T>> List<List<T>> perm(T array[]) {
        System.out.println("------perm--------");
        System.out.println("array: " + Arrays.toString(array));
        if (array.length == 1) {
            List<List<T>> results = new ArrayList<>();
            List<T> result = new ArrayList<T>();
            result.add(array[0]);
            results.add(result);
            System.out.println(results.toString());
            return results;
        }
        if (array.length == 0) {
            List<List<T>> results = new ArrayList<>();
            System.out.println("array is empty");
            return results;
        }

//        QuickSort<T> quickSort = new QuickSort<T>();
//        quickSort.quickSort(array, 0, array.length-1);
        List<List<T>> results = new ArrayList<>();
        for (int i = 0; i != array.length; i++) {
            // 同样的递归过程中不得修改原数组
            T[] arrayCopied = Arrays.copyOf(array, array.length);
            T elem = arrayCopied[i];
            // remove array[i] from array
            for (int j = i; j != arrayCopied.length-1; j++) {
                arrayCopied[j] = arrayCopied[j+1];
            }
            arrayCopied = Arrays.copyOfRange(arrayCopied, 0, arrayCopied.length-1);

            List<List<T>> subResults = new PermTest().perm(arrayCopied);
            for (List<T> l : subResults) {
                List<T> result = new ArrayList<>();
                result.add(elem);
                result.addAll(l);
                results.add(result);
            }
        }
        System.out.println("results: " + results.toString());
        return results;
    }



    public static void main(String[] args) {
        PermTest test = new PermTest();
        Integer array[] = {1, 3, 5, 9};
        List<List<Integer>> results = test.perm(array);
    }
}
