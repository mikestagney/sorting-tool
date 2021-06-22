package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericSorter<T> {

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
    /*
    public T getGreatest() {
        Collections.sort(list);


    }*/


}
