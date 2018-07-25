package cn.jccomp.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by bitbook on 3/21/18.
 * 对一亿条数据进行排序，选出其中最大的前100条数据
 */
public class BigDataSort {
    static Logger logger = LoggerFactory.getLogger(BigDataSort.class);
    private static Random random = new Random();
    private static int dataSize = 1 << 24;
    private static int[] datas;
    private static int randomMax = 1000;

    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };
    private static Map<Integer, List<Integer>> map = new TreeMap<>(comparator);

    static {
        datas = new int[dataSize];
        for (int i = 0; i != dataSize; i++) {
            datas[i] = random.nextInt(randomMax);
        }
    }

    public static int[] top100() {
        int max = -1;
        for (int data : datas) {
            max = max < data ? data : max;
        }
        for (int idx= 0; idx != dataSize; idx++) {
            if (map.get(datas[idx]) == null) {
                List<Integer> list = new LinkedList<>();
                list.add(idx);
                map.put(datas[idx], list);
            } else {
                map.get(datas[idx]).add(idx);
            }
        }
        int cnt = 0;
        int[] result = new int[100];
        while(cnt != 100) {
            Set<Integer> keyset = map.keySet();
            for (int key : keyset) {
                List<Integer> indexes = map.get(key);
                Iterator<Integer> iter = indexes.iterator();
                while (cnt < 100) {
                    result[cnt++] = iter.next();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = top100();
        for (int i = 0; i != result.length; i++) {
            result[i] = datas[result[i]];
        }
        logger.info("{}", Arrays.toString(result));
    }
}
