package chapter03.singleton;

public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton(); // static 초기화시 바로 할당

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
