package sorting;

import java.util.Collections;
import java.util.List;

public class GenericSorter<T extends Comparable<? super T>> {

    List<T> list;
    String dataName;

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
    /*
    public <T extends String> T getLongestString() {
        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());

    }*/
    public T getItem(int index) {
        return list.get(index);
    }

    public void sortList() {
        T[] sortArray = new T[list.size()];

        for (int i = 1; i < list.size(); i++) {
            T element = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(element) < 0) {
                T temp = list.get(j);
                System.out.println("temp" + temp);
                list.add(j + 1, temp);
                j--;
            }

            list.add(j + 1, element);

        }

    }
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T element: list) {
            builder.append(element.toString()).append(" ");
        }
        return builder.toString();
    }


}
