package chapter03.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void lazySingleton() {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();

        assertEquals(instance1, instance2);
    }

    @Test
    public void eagerSingleton() {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();

        assertEquals(instance1, instance2);
    }

    @Test
    public void lazyHolderSingleton() {
        LazyHolderSingleton instance1 = LazyHolderSingleton.getInstance();
        LazyHolderSingleton instance2 = LazyHolderSingleton.getInstance();

        assertEquals(instance1, instance2);
    }

}
