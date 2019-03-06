package chapter04.composite;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CompositeTest {

    @Test
    public void FloppyDiskTest() {
        FloppyDisk floppyDisk = new FloppyDisk();
        assertThat(floppyDisk.netPrice(), is(10));
    }

    @Test
    public void compositeEquipmentTest() {
        Cabinet cabinet = new Cabinet();
        Chassis chassis = new Chassis();

        cabinet.add(chassis);

        Bus bus = new Bus();
        bus.add(new Card());

        chassis.add(bus);
        FloppyDisk floppyDisk = new FloppyDisk();
        chassis.add(floppyDisk);

        assertThat(bus.netPrice(), is(11));
        assertThat(floppyDisk.netPrice(), is(10));
        assertThat(chassis.netPrice(), is(21)); // 11 + 10
    }

}