package cn.jccomp.utils;

import java.util.Scanner;

/**
 * Created by bitbook on 3/22/18.
 */
public class IOUtil {
    public static int getInteger(String prompt) {
        System.out.println(prompt);
        String sInput;
        Scanner scanner = new Scanner(System.in);
        sInput = scanner.nextLine();
        int input;
        try {
            input = Integer.parseInt(sInput);
        } catch (NumberFormatException e) {
            System.out.println("invalid input. ");
            input = Integer.parseInt(scanner.nextLine());
        }
        return input;
    }
}
