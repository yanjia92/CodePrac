package cn.jccomp.concurrent;

import cn.jccomp.TestCaseWithLogger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by bitbook on 3/20/18.
 */
public class ProducerConsumerInJava implements TestCaseWithLogger {
    private static List<Integer> queue = new LinkedList<>();

    static class Producer implements Runnable {
        private final Integer qsize;
        private final List<Integer> q;
        private final Random random;
        public Producer(Integer maxSize, List<Integer> queue) {
            this.q = queue;
            this.qsize = maxSize;
            this.random = new Random();
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this.q) {
                    while (this.q.size() >= this.qsize) {
                        try {
                            logger.debug("producer waiting on queue(size={})", this.q.size());
                            this.q.wait(); // wait是否会释放锁
                        } catch (InterruptedException e) {}
                    }
                    Integer v = this.random.nextInt(15);
                    logger.debug("producer put {}", v);
                    this.q.add(v);
                    this.q.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final List<Integer> q;
        private final Integer qsize;

        public Consumer(List<Integer> q, Integer qsize) {
            this.q = q;
            this.qsize = qsize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this.q) {
                    while (this.q.isEmpty()) {
                        try {
                            this.q.wait();
                        } catch (InterruptedException e) {}
                    }
                    Integer v = this.q.remove(this.q.size()-1);
                    this.q.notifyAll();
                    logger.debug("consumer get {}", v);
                }
            }
        }
    }

    @Override
    public void run() throws Exception{
        int qsize = 5;
        Thread producer = new Thread(new Producer(qsize, queue));
        Thread consumer = new Thread(new Consumer(queue, qsize));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

    public static void main(String args[]) throws Exception{
//        new ProducerConsumerInJava().run();
        logger.info("{}", new String("jjj") == new String("jjj"));
    }
}
