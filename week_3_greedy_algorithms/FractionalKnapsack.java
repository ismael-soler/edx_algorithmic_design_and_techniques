import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int[] amounts = new int[values.length];
        double totalValue = 0;

        for (int i = 0; i < values.length; i++) {
            if (capacity == 0) {
                return totalValue;
            }

            int bestItemIndex = getBestItem(values, weights);
            double a = Math.min(weights[bestItemIndex], capacity);

            totalValue += a * ((double)values[bestItemIndex] / (double)weights[bestItemIndex]);

            weights[bestItemIndex] -= a;

            amounts[bestItemIndex] += a;

            capacity -= a;
        }

        return totalValue;
    }

    private static int getBestItem(int[] values, int[] weights) {
        double maxValuePerWeight = 0;
        int bestItem = 0;

        for (int i = 0; i < values.length; i++) {
            if (weights[i] > 0) {
                double itemValue = (double) values[i] / (double) weights[i];
                if (itemValue > maxValuePerWeight) {
                    maxValuePerWeight = itemValue;
                    bestItem = i;
                }
            }
        }
        return bestItem;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}