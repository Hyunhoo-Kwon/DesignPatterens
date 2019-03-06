package chapter04.composite;

import java.util.Collections;
import java.util.List;

public class FloppyDisk implements Equipment {

    @Override
    public int netPrice() {
        return 10;
    }

    @Override
    public List<Equipment> createIterator() {
        return Collections.emptyList();
    }

    @Override
    public void add(Equipment equipment) {

    }

    @Override
    public void remove(Equipment equipment) {

    }

}
