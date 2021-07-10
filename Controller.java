package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Controller {
    Scanner input;
    String dataType = "word";
    String sortType = "natural";
    GenericSorter sorter;
    String[] arguments;
    String inputFile = "";
    String outputFile = "";

    Controller(String[] args) {
        input = new Scanner(System.in);

        arguments = args.clone();
        for (int i = 0; i < arguments.length; i++) {
            switch (arguments[i]) {
                case("-sortingType"):
                    if (isNextArgOK(i)) {
                        sortType = arguments[i + 1];
                    } else {
                        System.out.println("No sorting type defined!");
                    }
                    break;
                case("-dataType"):
                    if (isNextArgOK(i)) {
                        dataType = arguments[i + 1];
                    } else {
                        System.out.println("No data type defined!");
                    }
                    break;
                case("-inputFile"):
                    if (isNextArgOK(i)) {
                        inputFile = arguments[i + 1];
                    } else {
                        System.out.println("No input file name defined!");
                    }
                    break;
                case("-outputFile"):
                    if (isNextArgOK(i)) {
                        outputFile = arguments[i + 1];
                    } else {
                        System.out.println("No output file name defined!");
                    }
                    break;
                default:
                    if (args[i].startsWith("-")) {
                        System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", arguments[i]);
                    }
                    break;

            }
        }
        if (!inputFile.equals("")) {
            File file = new File(inputFile);
            try(Scanner scanner = new Scanner(file)) {
                ArrayList<String> wordList = new ArrayList<>();
                while (scanner.hasNext()) {
                    String temp = scanner.next();
                    wordList.add(temp);
                }
                sorter = new GenericSorter<>(wordList, "word");
            } catch (FileNotFoundException e) {
                System.out.println("Input file not found!");
            }
        } else {
            switch (dataType) {
                case ("long"):
                    sorter = new GenericSorter<>(getLongInput(), "number");
                    break;
                case ("line"):
                    sorter = new GenericSorter<>(getLineInput(), "line");
                    break;
                case ("word"):
                    sorter = new GenericSorter<>(getWordInput(), "word");
                    break;
            }
        }
        if (!outputFile.equals("")) {
            try {
                FileOutputStream file = new FileOutputStream(outputFile);
                System.setOut(new PrintStream(file));
            } catch (FileNotFoundException e) {
                System.out.println("Output file not found!");
            }
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
        while (input.hasNext()) {
            try {
                temp = input.next();
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
        while (input.hasNext()) {
            String temp = input.nextLine();
            lineList.add(temp);
        }
        return lineList;
    }
    private ArrayList<String> getWordInput() {
        ArrayList<String> wordList = new ArrayList<>();
        while (input.hasNext()) {
            String temp = input.next();
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
    private boolean isNextArgOK(int i) {
        return i + 1 < arguments.length && !arguments[i + 1].equals("") && !arguments[i + 1].startsWith("-");
    }
}
