package chapter04.composite;

import java.util.Collections;
import java.util.List;

public class Card implements Equipment {

    @Override
    public int netPrice() {
        return 11;
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
