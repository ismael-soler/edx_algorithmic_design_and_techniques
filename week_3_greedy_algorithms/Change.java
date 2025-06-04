import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int counter = 0;
        int currentValue = m;

        while (currentValue != 0) {
            if (currentValue >= 10) {
                currentValue -= 10;
            } else if (currentValue >= 5){
                currentValue -= 5;
            } else {
                currentValue -= 1;
            }
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

