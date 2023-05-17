package org.uade.arrays;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private List<Character> array;

    private int count;

    public Filter() {
        this.array = new ArrayList<>();
        this.count = 0;
    }
    public List<Character> getArray() {
        return array;
    }

    public void add(char a) {
        this.array.add(a);
        count ++;
    }
}
