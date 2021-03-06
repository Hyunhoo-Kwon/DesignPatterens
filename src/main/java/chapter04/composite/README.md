## 복합체 (Composite)

### 목적
부분과 전체의 계층을 표현하기 이해 객체들을 모아 트리 구조로 구성하여 사용자로 하여금 개별 객체와 복합 객체를 모두 동일하게 다룰 수 있도록 하는 패턴

### 동기
- 개별 객체와 복합 객체를 구분하기 위해 속성/코드 값을 기억하고 분기처리를 해야한다

### 활용
- 부분-전체의 객체 계통을 표현하고 싶을 때
- 사용자가 객체의 합성으로 생긴 복합 객체(Composite)와 개개의 객체(Leaf) 사이의 차이를 알지 않고도 자기 일을 할 수 있도록 만들고 싶을 때

### 이점
- 사용자 코드가 단순해진다: 기본 객체와 복합 객체를 구분하지 않고 일관되게 프로그래밍 할 수 있다
- 새로운 종류의 구성요소를 쉽게 추가할 수 있다: 새로운 요소가 추가되었다고 해서 사용자의 프로그램이 변경될 필요는 전혀 없다

### 단점
- 설계가 지나치게 범용성을 많이 갖는다: 새로운 요소를 쉽게 추가할 때의 단점은 복합체의 구성요소에 제약을 가하기 힘들다

### 구조
- Component: 집합 관계에 정의될 모든 객체에 대한 인퍼테이스를 정의
- Leaf: 가장 말단의 객체, 즉 자식이 없는 객체를 의미
- Composite: 자식이 있는 구성요소에 대한 행동을 정의
- Client: Component 인터페이스를 통해 복합 구조 내의 객체들을 조작

> 자식을 관리하는 Add(), Remove() 연산을 어느 클래스에 선언할 것인지?
> - 투명성을 우선하는 경우: Component에 선언하고 Leaf 클래스에서는 연산이 실패하도록(예외 등) 정의하면, 서브클래스 모두에게 동일한 인터페이스가 유지되어 이를 사용하는 사용자에게 인터페이스의 투명성을 부여할 수 있다. 반대로 사용자가 Leaf 클래스의 인스턴스에서 Add(), Remove() 연산을 호출하는 의미 없는 행동을 하지 않도록 안전성 유지를 위한 비용을 지불해야 한다.
> - 안전성을 우선하는 경우: Component 클래스와 이 서브클래스에만 연산을 정의하면, 사용자는 Leaf 클래스의 인스턴스에서 이런 연산을 요청하지 않으므로 안전성을 보장받는다. 그러나 Leaf 클래스와 Composite 클래스가 서로 다른 인터페이스를 갖게 되므로 사용자는 이를 동일한 대상으로 간주하고 사용할 수 없게 된다.

### 구현
- Component: [Equipment](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/composite/Equipment.java)
```
public interface Equipment {
    public int netPrice();
    public List<Equipment> createIterator();
    public void add(Equipment equipment);
    public void remove(Equipment equipment);
}
```

- Leaf: [FloppyDisk](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/composite/FloppyDisk.java), [Card](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/composite/Card.java)
```
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
```

- Composite: [CompositeEquipment](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/composite/CompositeEquipment.java), Cabinet, Chassis, Bus
```
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
```
```
public class Cabinet extends CompositeEquipment {
}
```

- Client: [테스트 코드](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/test/java/chapter04/composite/CompositeTest.java)
```
public class CompositeTest {
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
```

### 참고
- [JAVA composite pattern](https://jdm.kr/blog/228)
- [jQuery composite pattern](https://subscription.packtpub.com/book/web_development/9781785888687/1/ch01lvl1sec09/the-composite-pattern)
