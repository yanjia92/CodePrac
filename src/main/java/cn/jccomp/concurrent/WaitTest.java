package cn.jccomp.concurrent;

/**
 * Created by bitbook on 3/2/18.
 * 测试wait(long)方法是否会释放锁
 * 实验表明，wait()和wait(long)方法均会释放锁
 */
public class WaitTest {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        new Thread(new Thread2()).start();
    }

    public static class Thread1 implements Runnable {
        public void run() {
            synchronized (WaitTest.class) {
                System.out.println("Th1 begin");
                try {
                    WaitTest.class.wait(10000);
                } catch (InterruptedException e) {

                }
                System.out.println("Th1's over");
            }
        }
    }

    public static class Thread2 implements Runnable {
        public void run() {
            synchronized (WaitTest.class) {
                System.out.println("Th2 begin");

                System.out.println("Th2's over");
            }
        }
    }
}
