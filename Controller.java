package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    Scanner scanner;
    //GenericSorter<T> sorter;
    
    Controller(String[] args) {

        String dataType = "word";
        scanner = new Scanner(System.in);
        //GenericSorter<T> sorter;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-dataType")) {
                switch (args[i + 1]) {
                    case ("long"):
                        GenericSorter<Long> longNums = new GenericSorter<>(getLongInput(), "number");
                        printStatistics(longNums);
                        System.exit(0);
                        break;
                    case ("line"):
                        dataType = "line";
                        break;
                    default:

                        break;
                }
            }
        }
        GenericSorter<String> words = new GenericSorter<>(getWordInput(), "word");
        printStatistics(words);

    }




    /*
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

    }*/
       


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
            String temp = scanner.nextLine();
            String[] words = temp.split(" ");
            wordList.addAll(Arrays.asList(words));

        }
        return wordList;
    }

    private <T> void printStatistics(GenericSorter<T> genericSorter) {
        System.out.printf("Total %ss: %d\n",genericSorter.getDataName(), genericSorter.getTotal());
        //System.out.printf("The greatest number: %d (%d time(s)).\n", greatestNumber, numOfGreat);
        
        

    }




}
