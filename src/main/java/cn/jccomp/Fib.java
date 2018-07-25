package cn.jccomp;

/**
 * Created by bitbook on 2/22/18.
 * 计算第n个斐波那契数
 */
public class Fib {
    private static int[] records = null;

    // 计算第n个斐波那契数
    public static int fib(int n) {
        if (n <= 1) return n;
        if (null == records) {
            records = new int[n + 1];
            records[0] = 0;
            records[1] = 1;
            records[2] = 1;
        }
        if (records[n-1] != 0 && records[n-2] != 0)
            return records[n-1]+records[n-2];
        else
            return fib(n-1)+fib(n-2);
     }

     public static void main(String[] args) {
         for (int n = 10; n != 1; n--) {
             System.out.println(fib(n));
         }
     }
}
