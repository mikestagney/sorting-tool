package sorting;

import java.util.*;

public class Controller {
    Scanner scanner;

    Controller(String[] args) {
        scanner = new Scanner(System.in);

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortIntegers")) {
                GenericSorter<Integer> intsToSort = new GenericSorter<>(getIntInput(), "numbers");
                intsToSort.sortList();
                printIntegers(intsToSort);
                System.exit(0);
            } else if (args[i].equals("-dataType")) {
                switch (args[i + 1]) {
                    case ("long"):
                        GenericSorter<Long> longNums = new GenericSorter<>(getLongInput(), "number");
                        printStatistics(longNums);
                        System.exit(0);
                        break;
                    case ("line"):
                        GenericSorter<String> lines = new GenericSorter<>(getLineInput(), "line");
                        printStatistics(lines);
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
        GenericSorter<String> words = new GenericSorter<>(getWordInput(), "word");
        printStatistics(words);
        }

    private List<Long> getLongInput() {
        List<Long> longList = new ArrayList<>();
        while (scanner.hasNextLong()) {
            Long temp = scanner.nextLong();
            longList.add(temp);
        }
        return longList;
    }
    private ArrayList<String> getLineInput() {
        ArrayList<String> lineList = new ArrayList<>();
        while (scanner.hasNext()) {
            String temp = scanner.nextLine();
            lineList.add(temp);
        }
        return lineList;
    }
    private ArrayList<String> getWordInput() {
        ArrayList<String> wordList = new ArrayList<>();
        while (scanner.hasNext()) {
            String temp = scanner.next();
            wordList.add(temp);
        }
        return wordList;
    }
    private ArrayList<Integer> getIntInput() {
        ArrayList<Integer> intList = new ArrayList<>();
        while (scanner.hasNext()) {
            Integer temp = scanner.nextInt();
            intList.add(temp);
        }
        return intList;
    }

    private <T extends Comparable> void printStatistics(GenericSorter<? super T> genericSorter) {

            System.out.printf("Total %ss: %d.\n", genericSorter.getDataName(), genericSorter.getTotal());

            T greatest = genericSorter.dataName.equals("number") ? (T)genericSorter.getGreatestNumber() : (T) getLongestString(genericSorter);
            String superlative = genericSorter.dataName.equals("number") ? "greatest" : "longest";
            int numOfTimes = genericSorter.frequencyItem(greatest);
            int percent = numOfTimes * 100 / genericSorter.getTotal();

            if (genericSorter.dataName.equals("line")) {
                System.out.printf("The %s %s:\n%s\n(%s time(s)), %d%%).\n", superlative, genericSorter.getDataName(), greatest, numOfTimes, percent);
            } else {
                System.out.printf("The %s %s: %s (%s time(s)), %d%%).\n", superlative, genericSorter.getDataName(), greatest, numOfTimes, percent);
            }
    }
    private <T> void printIntegers(GenericSorter<? super T> intSorted) {
        System.out.printf("Total %s: %d.\n", intSorted.getDataName(), intSorted.getTotal());
        System.out.printf("Sorted data: %s\n", intSorted);
    }

    private<T> String getLongestString(GenericSorter<? super T> stringList) {
        String longest = "";
        for (int i = 0; i < stringList.getTotal(); i++) {
            String test = stringList.getItem(i).toString();
            if (longest.length() < test.length()) {
                longest = test;
            }
        }
        return longest;
    }



}
