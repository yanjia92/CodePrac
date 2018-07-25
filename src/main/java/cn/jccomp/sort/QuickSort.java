package cn.jccomp.sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by bitbook on 3/7/18.
 */
public class QuickSort<T extends Comparable<T>> {

    public int partition(T[] array, int l, int r) {
        if (l > r) {
            throw new RuntimeException("invalid parameters in partition");
        }
        int i = l, j = r;
        T pivot = array[i];
        while (i < j) {
            while(i < j && array[j].compareTo(pivot) > 0) j--;
            array[i] = array[j];
            while(i < j && array[i].compareTo(pivot) < 0) i++;
            array[j] = array[i];
        }
        if (i != j) {
            System.out.println(MessageFormat.format("i = {0}, j = {1}", i, j));
            throw new RuntimeException("i != j");
        }

        array[i] = pivot;
        return i;
    }

    // l,r都是inclusive的index
    public void quickSort(T[] array, int l, int r) {
        if (l == r) return;
        int index = partition(array, l, r);

        quickSort(array, l, index-1);
        quickSort(array, index+1, r);
    }

    // 返回一个数组中最小的N个数
    public T[] leastN(T array[], int N) {
        // 快速排序算法思想，调用partition函数对数组进行划分，直到partition函数返回N
        int len = array.length;
        if (N < 0 || N > len) {
            return null;
        }
        if (N == len) {
            return array;
        }
        int index= partition(array, 0, len-1);
        while (index != N) {
            if (index < N) {
                index = partition(array, index+1, len-1);
            } else {
                index = partition(array, 0, index-1);
            }
        }
        return Arrays.copyOfRange(array, 0, N);
    }

    public static void main(String[] args) {
        Integer[] array = {4, 5, 6, 1, 9};
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(quickSort.leastN(array, 5)));
    }
}
