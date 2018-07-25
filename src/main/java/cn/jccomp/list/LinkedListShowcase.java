package cn.jccomp.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by bitbook on 3/23/18.
 */
public class LinkedListShowcase {
    static LinkedList<Integer> list = new LinkedList<Integer>();
    static Scanner scanner = new Scanner(System.in);
    static Logger logger= LoggerFactory.getLogger(LinkedListShowcase.class);

    static void getInput() {
        while (scanner.hasNext()) {
            String next = null;
            try {
                next = scanner.next();
                int i = Integer.parseInt(next);
                list.add(i);
            } catch (NumberFormatException e) {
                if (next.equals("q")) break;
            }
        }
//        logger.info(Arrays.toString(list.toArray()));
    }

    static void test() {
        while (scanner.hasNext()) {
            String next=null;
            try {
                next = scanner.next();
                Integer i = Integer.parseInt(next);
                list.add(i);
            } catch (NumberFormatException e) {
                if (next.equals("q")) {
                    break;
                }
            }
        }
        logger.info("{}", list.getFirst());
    }

    static void testListItr() {
        getInput();
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext() && iter.nextIndex() < 2) {
            // get the first two elements
            logger.info("v={}, nextIndex={}", iter.next(), iter.nextIndex());
        }
        if (iter.hasPrevious()) {
            logger.info("prev={}, previdx={}", iter.previous(), iter.previousIndex());
        }
    }

    public static void main(String[] args) {
//        test();
        testListItr();
    }
}
