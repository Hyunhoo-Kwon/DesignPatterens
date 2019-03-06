package chapter04.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeEquipment implements Equipment {

    private List<Equipment> equipments = new ArrayList<>();

    @Override
    public int netPrice() {
        List<Equipment> iterator = createIterator();
        int total = 0;

        for(Equipment equipment : iterator) {
            total += equipment.netPrice();
        }

        return total;
    }

    @Override
    public List<Equipment> createIterator() {
        return equipments;
    }

    @Override
    public void add(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void remove(Equipment equipment) {
        equipments.remove(equipment);
    }
}
