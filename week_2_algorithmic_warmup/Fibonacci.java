package week_2_algorithmic_warmup;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getSmallFibonacciNumber(n));
    }

    private static int getSmallFibonacciNumber(int n) {
        if (n <= 1) {
            return n;
        }

        int[] sequence = new int[n + 1];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < sequence.length; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence[n];
    }
}