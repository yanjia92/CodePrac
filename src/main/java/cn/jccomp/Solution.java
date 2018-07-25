package cn.jccomp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by bitbook on 3/22/18.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = null;

        while(scanner.hasNext()) {
            s = scanner.nextLine();
            char[] ch = s.toCharArray();
            int [] value = new int[10];
            int[] value1 = new int[10];
            for (int j =0 ; j < ch.length; j++) {
                value[ch[j]-'0']++;
                value1[ch[j]-'0']++;
            }

            Arrays.sort(value1);
            int min = value1[0];
            int a = Arrays.binarySearch(value, min);
            StringBuilder s1 = new StringBuilder();
            for (int i = 0;  i < min+1;i++) {
                s1.append(a);
            }
            System.out.println(s1);
        }
    }



}
