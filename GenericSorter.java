package sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericSorter<T extends Comparable<? super T>> {

    List<T> list;
    String dataName;
    Map<T,Integer> frequencyMap;

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

    public T getGreatestNumber() {
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
    public int frequencyItem(T check) {
        int numTimes = 0;
        for (T item: list ) {
            if (item.equals(check)) {
                numTimes++;
            }
        }
        return numTimes;
    }

    public T getItem(int index) {
        return list.get(index);
    }

    public void countSort() {
        // create map from list with value = frequency
        frequencyMap = new HashMap<T, Integer>();
        for (int i = 1; i < list.size(); i++) {
            int count = 1;
            T element = list.get(i);
            if (frequencyMap.containsKey(element)) {
                count = frequencyMap.get(element);
                count++;
            }
            frequencyMap.put(element, count);
        }

        frequencyMap.forEach((k , v ) -> System.out.println(k.toString() + " " + v));


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
