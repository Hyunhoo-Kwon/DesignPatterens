package chapter04.composite;

import java.util.List;

public interface Equipment {

    public int netPrice();
    public List<Equipment> createIterator();
    public void add(Equipment equipment);
    public void remove(Equipment equipment);
}
