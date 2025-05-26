package week_2_algorithmic_warmup;
import java.util.Scanner;

public class FibonacciLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getFibonacciLastDigit(n));

    }

    private static int getFibonacciLastDigit(int n) {
        if (n <= 1) {
            return n;
        }
        int[] sequence = new int[n];
        sequence[0] = 0;
        sequence[1] = 1;

        for (int i = 2; i < n; i++) {
            sequence[i] = (sequence[i - 1] + sequence[i - 2]) % 10;
        }
        return (sequence[n - 1] + sequence[n - 2]) % 10;
    }
}