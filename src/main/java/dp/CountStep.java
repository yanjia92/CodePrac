package dp;

import java.util.Scanner;

/**
 * Created by bitbook on 3/22/18.
 */
public class CountStep {
    final static String prompt = "Input a number: \n";
    static int[] dp;

    static int getInput(String[] args) {
        String sInput;
        Scanner scanner = new Scanner(System.in);
        if (args.length > 1) {
            sInput = args[1];
        } else {
            sInput = scanner.nextLine();
        }
        int input;
        try {
            input = Integer.parseInt(sInput);
        } catch (NumberFormatException e) {
            System.out.println("invalid input. ");
            input = Integer.parseInt(scanner.nextLine());
        }
        return input;
    }

    static int resultForN(int n) {
        if (n <= 1) {
            dp[n] = 1;
            return 1;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += resultForN(i);
        }
        dp[n] = result;
        return dp[n];
    }

    public static void main(String[] args) {
        int input = getInput(args);
        dp = new int[input+1];
        System.out.println(resultForN(input));
    }
}
