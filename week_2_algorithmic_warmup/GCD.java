package week_2_algorithmic_warmup;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getGCD(a, b));

    }

    private static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return getGCD(b, a % b);
    }
}