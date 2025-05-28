package week_2_algorithmic_warmup;

import java.util.*;

public class FibonacciSumLastDigit {
    public static void main(String[] args) {
        // stressTest();

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        int convertedIndex = convertIndex(n);

        int fibNumber = getFibonacciNumber(convertedIndex) - 1;
        if (fibNumber == -1) {
            fibNumber = 9;
        }
        System.out.println(fibNumber);
    }

    private static int getFibonacciNumber(int index) {
        if (index <= 1) {
            return index;
        }
        
        int[] list = new int[index + 1];
        list[0] = 0;
        list[1] = 1;

        for (int i = 2; i < list.length; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 10;
        }
        return list[index];
    }

    private static int convertIndex(long n) {
        int reducedIndex = (int) ((n + 2) % 60);
        return reducedIndex;
    }

    private static void stressTest() {
        Random rand = new Random(123323L);
        while (true) {
            long nBound = 100L;
            long n = rand.nextLong(nBound) + 1;

            System.out.println("*** CASE: n = " + n + " ***");
            int convertedIndex = convertIndex(n);
            int fibNumber = getFibonacciNumber(convertedIndex) - 1;
            if (fibNumber == -1) {
                fibNumber = 9;
            }
            long naiveMethodAnswer = getFibonacciSumNaive(n);

            if (fibNumber == naiveMethodAnswer) {
                System.out.println("OKAY!");
            } else {
                System.out.println("naive answer was: " + naiveMethodAnswer);
                System.out.println("fast answer was: " + fibNumber);
                break;
            }
        }
    }

    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
}
