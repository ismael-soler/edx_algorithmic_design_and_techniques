package week_2_algorithmic_warmup;

import java.util.*;

public class LCM {    
    private static long getLCM(long a, long b) {
        return (long)(a * b) / getGCD(a, b);
    }

    private static long getGCD(long a, long b) {
        if (a % b == 0) {
            return b;
        }

        return getGCD(b, a % b);
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        System.out.println(getLCM(a, b));
    }
}
