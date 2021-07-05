package sorting;

import java.util.*;
import java.util.stream.Collectors;

public class GenericSorter<T extends Comparable> {

    List<T> list;
    String dataName;
    Map<T,Integer> valueSortedMap;

    GenericSorter(List<T> inputList, String name) {
        list = inputList;
        dataName = name;
    }

    public int getTotal() {
        return list.size();
    }

    public String getDataName() {
        return dataName;
    }

    public void countSort() {
        Map<T, Integer> frequencyMap = new TreeMap<>();
        for (T element: list) {
            int count = 1;
            if (frequencyMap.containsKey(element)) {
                count = frequencyMap.get(element);
                count++;
            }
            frequencyMap.put(element, count);
        }
        valueSortedMap = frequencyMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey,
            Map.Entry::getValue, (oldValue, newValue) -> oldValue,
            LinkedHashMap::new));
    }
    public String printStringByCount() {
        StringBuilder builder = new StringBuilder();
        valueSortedMap.forEach((k, v) -> builder.append(k.toString()).append(": ")
                .append(v)
                .append(" time(s), ")
                .append(v * 100 / list.size())
                .append("%%\n"));
        return builder.toString();
    }
    public void naturalSort() {
        for (int i = 1; i < list.size(); i++) {
            T element = list.get(i);
            list.remove(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(element) > 0) {
                j--;
            }
            list.add(j + 1, element);
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T element: list) {
            builder.append(element.toString());
            if (dataName.equals("line")) {
                builder.append("\n");
            } else {
                builder.append(" ");
            }
        }
        if (dataName.equals("line")) {
            builder.insert(0, "\n");
        }
        return builder.toString();
    }
}
