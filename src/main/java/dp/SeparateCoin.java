package dp;

import cn.jccomp.bisect.Bisect;
import cn.jccomp.utils.IOUtil;

/**
 * Created by bitbook on 3/22/18.
 * https://www.nowcoder.com/question/next?pid=5583018&qid=105231&tid=14358221
 * 为什么这种算法是错的？比如说要求凑够6元的方案数，那么不能按照面额对子问题进行划分。
 * 因为比方说把6元划分为1+5, 2+4, 但是1+5的方案和2+4的方案明显存在重复，即1+1+1+1+1+1。
 * 所以应该重新审视下子问题划分的方法。
 *
 */
public class SeparateCoin {
    static int[] dp;
    static int[] coins = new int[]{1, 5, 10, 20, 50, 100};

    static int solution(int input) {
        if (dp[input] > 0) {
            return dp[input];
        }
        if (input == 1 || input == 0) {
            dp[input] = 1;
            return 1;
        }
        int posInCoins = Bisect.bisect(coins, input);
        int result = 0;
        for (int i = 0; i < posInCoins; i++) {
            int solutionSub = solution(input-coins[i]);
            dp[input-coins[i]] = solutionSub;
            result += solutionSub;
        }
        if (coins[posInCoins] == input) {
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        while (true) {
            int input = IOUtil.getInteger("Input a number:");
            dp = new int[input+1];
            System.out.println(solution(input));
        }
    }
}
