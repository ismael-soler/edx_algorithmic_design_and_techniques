package week_2_algorithmic_warmup;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FibonacciPartialSum {
    public static void main(String[] args) {
        // stressTest();

        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long n = sc.nextLong();

        int result = getResultFast(n, m);

        System.out.println(result);
    }

    private static void stressTest() {
        Random rand = new Random(3746L);

        while (true) {
            // long nBound = 1_000_000_000_000_000_000L;
            long nBound = 100;
            long n = rand.nextLong(nBound);
            long m = rand.nextLong(n + 1);

            System.out.println("For case n = " + n + " and m = " + m);
            int resultA = getResultFast(n, m);
            int resultB = (int) getFibonacciPartialSumNaive(m, n);

            if (resultA == resultB) {
                System.out.println("OKAY!");
            } else {
                System.out.println("resultA = " + resultA);
                System.out.println("resultB = " + resultB);
                break;
            }
        }
    }

    private static int getResultFast(long n, long m) {
        int[] convertedIndexes = getConvertedIndexes(m, n);
        int mP = convertedIndexes[0];
        int nP = convertedIndexes[1];

        int[] fibList = getLastDigitOfFibonacciSequenceList(Math.max(mP, nP));

        int valueAtN = fibList[nP];
        // System.out.println(valueAtN);
        int valueAtM = fibList[mP];
        // System.out.println(valueAtM);
        int result = valueAtN - valueAtM;
        if (result < 0) {
            result = 10 + result;
        }
        return result;
    }

    private static int[] getLastDigitOfFibonacciSequenceList(int nP) {
        int[] list = new int[nP + 1];
        list[0] = 0;
        list[1] = 1;

        for (int i = 2; i < list.length; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 10;
        }

        return list;
    }

    private static int[] getConvertedIndexes(long m, long n) {
        int[] convertedIndex = new int[2];
        convertedIndex[0] = (int) ((m + 1) % 60);
        convertedIndex[1] = (int) ((n + 2) % 60);
        return convertedIndex;
    }

    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
}
