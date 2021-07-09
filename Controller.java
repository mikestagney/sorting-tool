package sorting;

import java.util.*;

public class Controller {
    Scanner scanner;
    String dataType = "word";
    String sortType = "natural";
    GenericSorter sorter;
    String inputFile;
    String outputFile;

    Controller(String[] args) {
        scanner = new Scanner(System.in);

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case("-sortingType"):
                    if (i + 1 >= args.length || args[i + 1].equals("")) {
                        System.out.println("No sorting type defined!");
                    } else {
                        sortType = args[i + 1];
                    }
                    break;
                case("-dataType"):
                    if (i + 1 >= args.length || args[i + 1].equals("")) {
                        System.out.println("No data type defined!");
                    } else {
                        dataType = args[i + 1];
                    }
                    break;
                case("-inputFile"):
                    if (i + 1 >= args.length || args[i + 1].equals("")) {
                        System.out.println("No input file name defined!");
                    } else {
                        inputFile = args[i + 1];
                    }
                    break;
                case("-outputFile"):
                    if (i + 1 >= args.length || args[i + 1].equals("")) {
                        System.out.println("No output file name defined!");
                    } else {
                        outputFile = args[i + 1];
                    }
                    break;
                default:
                    if (args[i].startsWith("-")) {
                        System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", args[i]);
                    }
                    break;

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
        String temp = " ";
        while (scanner.hasNext()) {
            try {
                temp = scanner.next();
                Long number = Long.parseLong(temp);
                longList.add(number);
            } catch (NumberFormatException e) {
                System.out.printf("\"%s\" is not a long. It will be skipped.\n", temp);
            }
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
