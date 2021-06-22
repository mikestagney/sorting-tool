package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericSorter<T> {

    List<T> list;

    GenericSorter(List<T> inputList) {
        list = inputList;
    }

    public int getTotal() {
        return list.size();
    }
    /*
    public T getGreatest() {
        Collections.sort(list);


    }*/


}
