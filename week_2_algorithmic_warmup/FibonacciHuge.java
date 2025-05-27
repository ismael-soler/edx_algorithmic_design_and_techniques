package week_2_algorithmic_warmup;

import java.util.*;

public class FibonacciHuge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Options ----\n1: Manual Test\n2: StressTest\n-----------\n");
        // int option = 2;
        int option = sc.nextInt();

        if (option == 1) {
            long n = sc.nextLong();
            int m = sc.nextInt();
            // System.out.println("Answer: " + getFibonacciHugeFast(n, m));
            // System.out.println("Naive answer: " + getFibonacciHugeNaive(n, m));
            System.out.println(getFibonacciHugeFast(n, m));

        } else if (option == 2) {
            startStressTest();
        }
    }

    private static void startStressTest() {
        Random rand = new Random(789321L);
        while (true) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(0);
            list.add(1);

            // long nBound = 1_000_000_000_000_000_000L;
            long nBound = 90L;
            long n = rand.nextLong(nBound) + 1;

            // int mBound = 100000;
            int mBound = 100000;
            int m = rand.nextInt(mBound) + 2;

            System.out.println("**** CASE: n = " + n + " m = " + m + " ****");
            long fastMethodAnswer = getFibonacciHugeFast(n, m);
            long naiveMethodAnswer = getFibonacciHugeNaive(n, m);
            if (fastMethodAnswer == naiveMethodAnswer) {
                System.out.println("OKAY!");
            } else {
                System.out.println("naive answer was: " + naiveMethodAnswer);
                System.out.println("fast answer was: " + fastMethodAnswer);
                break;
            }
            System.out.println("---------------------\n\n");
        }
    }

    private static Integer getFibonacciHugeFast(long n, int m) {
        LinkedList<Integer> modList = new LinkedList<Integer>();
        // list.add(0);
        // list.add(1);

        // Create the Modlist
        modList = getPeriodList(modList, n, m);
        int periodLength = modList.size();
        long remainder = (n % periodLength);

        Integer pisanoMod = modList.get((int) remainder);
        return pisanoMod;
    }

    private static LinkedList<Integer> getPeriodList(LinkedList<Integer> listMod, long n, int m) {
        listMod.add(0);
        listMod.add(1);

        // We loop until n + 1 to make sure we find the (0 - 1) pattern
        // There might be some cases (e.g. n=9, m=3) in which
        // the period length (for m=3 it's 8) is n - 1.
        // We need to advance one more in order to find the '1' in the pattern.
        for (int i = 2; i < n + 1; i++) {
            int prevPrevMod = listMod.get(i - 2);
            int prevMod = listMod.get(i - 1);
            int currentMod = (prevPrevMod + prevMod) % m;
            listMod.add(currentMod);

            // Check if the '0-1' pattern appears
            if (prevMod == 0 && currentMod == 1) {
                listMod.removeLast();
                listMod.removeLast();
                return listMod;
            }
        }
        return listMod;
    }

    private static long getFibonacciHugeNaive(long n, int m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
}