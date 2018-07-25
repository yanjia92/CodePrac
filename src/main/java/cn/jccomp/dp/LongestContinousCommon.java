package cn.jccomp.dp;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by bitbook on 3/27/18.
 * 求两个序列的最长连续公共子列
 */
public class LongestContinousCommon {
    // 相对路径的根目录是项目的根目录
    final static String inputFile = "src/main/java/cn/jccomp/dp/input/input_lcc.txt";

    static String[] getInput(String inputFile)
    {
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            byte[] buf = new byte[1024];
            int read = 0;
            while ((read = fis.read(buf)) > 0) {
                String line = new String(buf, 0, buf.length).trim();
                System.out.println(line);
                return line.split("\\s+");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public static void main(String[] args) {
        String[] inputs = getInput(inputFile);
        char[] arr1 = inputs[0].toCharArray();
        char[] arr2 = inputs[1].toCharArray();
        int n1, n2;
        n1 = inputs[0].length();
        n2 = inputs[1].length();
        /*
        dp[i][j]表示以第一个序列第i个元素和第二个序列第j个元素为结尾的最长公共连续子序列
         */
        int[][] dp = new int[n1][n2];
        for (int j = 0; j != n2; j++)
            if (arr1[0] == arr2[j])
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        for (int i = 0; i != n1; i++)
            if (arr1[i] == arr2[0])
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
        int max = 0;
        for (int i = 1; i != n1; i++) {
            for (int j = 1; j != n2; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = max >= dp[i][j] ? max : dp[i][j];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }
}
