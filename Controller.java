package sorting;

import java.util.*;

public class Controller {
    Scanner scanner;
    String dataType = "word";
    String sortType = "natural";
    GenericSorter sorter;

    Controller(String[] args) {
        scanner = new Scanner(System.in);

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortingType")) {
                sortType = args[i + 1];
            } else if (args[i].equals("-dataType")) {
                dataType = args[i + 1];
            }
        }

        switch (dataType) {
            case("long"):
                sorter = new GenericSorter<>(getLongInput(), "number");
                break;
            case("line"):
                sorter = new GenericSorter<>(getLineInput(), "line");
                break;
            case("word"):
                sorter = new GenericSorter<>(getWordInput(), "word");
                break;
        }
        if (sortType.equals("byCount")) {
            sorter.countSort();
            printByCountSorted(sorter);
        } else {
            sorter.naturalSort();
            printNaturalSorted(sorter);
        }
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
    private void printByCountSorted(GenericSorter genericSorter) {
        System.out.printf("Total %ss: %d.\n", genericSorter.getDataName(), genericSorter.getTotal());
        System.out.printf("%s\n", genericSorter.printStringByCount());

    }
    private void printNaturalSorted(GenericSorter intSorted) {
        System.out.printf("Total %ss: %d.\n", intSorted.getDataName(), intSorted.getTotal());
        System.out.printf("Sorted data: %s\n", intSorted);
    }

}
