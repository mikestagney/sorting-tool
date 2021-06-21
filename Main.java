package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        long greatestNumber = Long.MIN_VALUE;
        int numOfGreat = 1;

        while (scanner.hasNext()) {
            long number = scanner.nextLong();
            counter++;
            if (number > greatestNumber) {
                greatestNumber = number;
                numOfGreat = 1;
            } else if (number == greatestNumber) {
                numOfGreat++;
            }

        }
        System.out.printf("Total numbers: %d\n", counter);
        System.out.printf("The greatest number: %d (%d time(s)).\n", greatestNumber, numOfGreat);
    }
}
