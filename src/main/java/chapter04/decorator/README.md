## 장식자 (Decorator or Wrapper)

### 목적
객체에 동적으로 새로운 책임을 추가할 수 있게 한다. 기능을 추가할 때, 서브클래스를 생성하는 것보다 융통성 있는 방법을 제공한다

### 동기
- 전체 클래스에 새로운 기능을 추가할 필요는 없지만, 개별적인 객체에 새로운 책임을 추가할 필요가 있는 경우 **상속을 통한 기능 확장**은 각 기능별로 클래스를 추가해야 한다
    - [예제코드](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter04/decorator/problem)) TextView 클래스에 스크롤바, 테두리, 그림자 기능이 필요하게 된다면 TextView의 서브클래스 TextViewWithBorder, TextViewWithScroll, TextViewWithDropShadow 클래스를 구현?
    - 2개, 3개 기능을 같이 사용하게 된다면 TextView의 서브클래스 TextViewWithBorderAndScroll, TextViewWithDropShadowAndBorderAndScroll 클래스를 구현?
    > 필요한 기능이 더 늘어나면 클래스 갯수가 기하급수적으로 늘어나게 된다
    
### 활용
- 동적이고 투명하게, 즉 다른 객체에 영향을 주지 않고 개개의 객체에 새로운 책임을 추가하기 위해 사용
- 제거될 수 있는 책임에 대해 사용

### 이점
- 상속보다 설계의 융통성을 증대시킬 수 있다: 장식자(Decorator)를 객체와 연결하거나 분리하는 작업을 통해 새로운 책임을 추가하거나 삭제하는 일을 런타임에 가능
- 상위 클래스(부모 클래스/인터페이스)에 많은 기능이 누적되는 상황을 피할 수 있다: 현재 사용되지 않는 기능까지 다 개발할 필요가 없이 나중에 그 기능이 필요할 때 새로운 종류의 장식자를 개발한다
- 장식자와 해당 장식자의 구성요소가 동일한 것은 아니다

### 단점
- 장식자를 사용함으로써 작은 규모의 객체들이 많이 생긴다: 클래스들이 어떻게 조합에 따라 새로운 객체가 계속 만들어진다. 이때 이 객체들을 잘 이해하고 있다면 시스템의 재정의가 쉽겠지만, 그렇지 않다면 객체들을 모두 이해하고 수정하는 과정이 복잡해진다

### 구조
- Component: 동적으로 추가할 서비스를 가질 가능성이 있는 객체들에 대한 인터페이스
- ConcreteComponent: 추가적인 서비스가 실제로 정의되어야 할 필요가 있는 객체
- Decorator: Component 객체에 대한 참조자를 관리하면서 Component에 정의된 인터페이스를 만족하도록 추상 클래스를 정의
- ConcreteDecorator: Component에 새롭게 추가할 서비스를 실제로 구현하는 클래스

### 구현
1. 인터페이스 일치시키기: ConcreteDecorator 클래스는 동일한 부모 클래스를 상속해야 한다
2. 추상 클래스로 정의되는 Decorator 클래스 생략하기: 추상 클래스인 Decorator 클래스를 정의할 필요가 없을 때도 있다. 이때 구성요소에게 요청을 전달하는 Decorator 클래스의 책임을 ConcreteDecorator 클래스와 합칠 수 있다
3. Component 클래스는 가벼운 무게 유지
4. 객체의 겉포장을 변경할 것인가, 속을 변경할 것인가

### 예제코드
- Component: [VisualComponent](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/decorator/VisualComponent.java)
```
public interface VisualComponent {
    public void draw();
    public void resize();
}
```

- ConcreteComponent: [TextView](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/decorator/TextView.java)
```
public class TextView implements VisualComponent {
    @Override
    public void draw() {
        System.out.println("TextView");
    }
    @Override
    public void resize() {

    }
}
```

- Decorator: [Decorator](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/decorator/Decorator.java)
```
public class Decorator implements VisualComponent {
    private VisualComponent component;

    public Decorator(VisualComponent component) {
        this.component = component;
    }
    @Override
    public void draw() {
        component.draw();
    }
    @Override
    public void resize() {
        component.resize();
    }
}
```

- ConcreteDecorator: [BorderDecorator](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/decorator/BorderDecorator.java), [ScrollDecorator](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/decorator/ScrollDecorator.java), [DropShadowDecorator](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter04/decorator/DropShadowDecorator.java)
```
public class BorderDecorator extends Decorator {
    private int width;

    public BorderDecorator(VisualComponent component, int width) {
        super(component);
        this.width = width;
    }
    @Override
    public void draw() {
        super.draw();
        drawBorder(width);
    }
    private void drawBorder(int width) {
        // ...
        System.out.println("drawBoard");
    }
}
```

- Client: [테스트 코드](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/test/java/chapter04/decorator/DecoratorTest.java)
```
public class DecoratorTest {
    @Test
    public void decoratorTest() {
        Window window = new Window();
        TextView textView = new TextView();

        window.setComponent(new DropShadowDecorator(new BorderDecorator(new ScrollDecorator(textView), 1)));
        window.getComponent().draw();
    }
}
```

### 참고
- [Java Decorator pattern](https://gmlwjd9405.github.io/2018/07/09/decorator-pattern.html)
- [Decorator pattern in JDK](https://www.javaworld.com/article/2075920/decorate-your-java-code.html)
    - [java Reader class](https://stackoverflow.com/questions/46994892/decorator-pattern-java-io-reader)
