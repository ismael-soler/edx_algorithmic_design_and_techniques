package week_1_programming_challenges;
import java.util.*;

public class MaxPairwiseProductFast {
    static long getMaxPairwiseProductFast(int[] numbers) {
        int index1 = 0;
        int n = numbers.length;

        for (int i = 1; i < n; i++) {
            if (numbers[i] > numbers[index1]) {
                index1 = i;
            }
        }
        int index2;
        if (index1 == 0) {
            index2 = 1;
        } else {
            index2 = 0;
        }

        for (int i = 1; i < n; i++) {
            // change this line
            if (i != index1 & numbers[i] > numbers[index2]) {
                index2 = i;
            }
        }
        return (long)numbers[index1] * numbers[index2];
    }

    static long getMaxPairwiseProductNaive(int[] numbers) {
        long product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                product = Math.max(product, (long)numbers[i] * numbers[j]);
            }
        }
        return product;
    }
    
    private static int[] getNumbers() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    private static void stressTest(int n, int m) {
        // random number generator with specific seed
        Random rand = new Random(123451L);
        while (true) {
            int numberOfValues = rand.nextInt(n - 2 + 1) + 2;
            int[] arrayOfValues = new int[numberOfValues];
            for (int i = 0; i < numberOfValues; i++) {
                arrayOfValues[i] = rand.nextInt(m - 0 + 1) + 0;
            }

            System.out.println(Arrays.toString(arrayOfValues));
            long result1 = getMaxPairwiseProductNaive(arrayOfValues);
            long result2 = getMaxPairwiseProductFast(arrayOfValues);

            if (result1 == result2) {
                System.out.println("OK");
            } else {
                System.out.println("Wrong Result: N:" + result1 + " F:" + result2);
                return;
            }
        }
    }
    public static void main(String[] args) {
        // stressTest(1000, 200000);

        int[] newarray = getNumbers();
        System.out.println(getMaxPairwiseProductFast(newarray));
    }
}
