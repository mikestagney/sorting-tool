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


    }
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T element: list) {
            builder.append(element.toString()).append(" ");
        }
        return builder.toString();
    }


}
