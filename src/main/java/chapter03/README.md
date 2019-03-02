# chapter03. 생성 패턴 (Creational Patterns)

### 정의
- 인스턴스를 만드는 절차를 추상화 하는 패턴
- 객체를 생성/합성하는 방법이나 객체의 표현 방법과 시스템을 분리

### 생성패턴의 핵심
1. 시스템이 어떤 구체 클래스를 사용하는지에 대한 정보를 캡슐화한다
2. 구체 클래스의 인스턴스들이 어떻게 만들고 서로 맞붙는지에 대한 부분을 가려준다

결론적으로, 생성 패턴을 이용하면 `무엇을, 누가, 어떻게, 언제` 생성하는데 유연성을 제공한다

### The Maze Problem
- [미로 생성 코드](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter03/intro)
```
public Maze createMaze() {
    Maze aMaze = new Maze();
    Room r1 = new Room(1);
    Room r2 = new Room(2);
    Door theDoor = new Door(r1, r2);

    aMaze.addRoom(r1);
    aMaze.addRoom(r2);

    r1.setSide(Direction.North, new Wall());
    r1.setSide(Direction.East, theDoor);
    r1.setSide(Direction.South, new Wall());
    r1.setSide(Direction.West, new Wall());

    r2.setSide(Direction.North, new Wall());
    r2.setSide(Direction.East, new Wall());
    r2.setSide(Direction.South, new Wall());
    r2.setSide(Direction.West, theDoor);

    return aMaze;
}
```
- 기존 미로가 갖고 있는 레이아웃을 재사용하면서 마법의 미로 게임을 만드는 방법은? 어떻게 하면 createMaze() 함수를 쉽게 바꿔 새로운 타입의 미로를 만들 수 있을까?
  - 마법의 미로 게임은 마법을 포함하는 EnchantedRoom과 같은 새로운 구성요소가 필요하다
- 위 코드의 문제는 라인 수가 많다는 것일까? 위 코드가 가진 진짜 문제는 유연성이 떨어진다는 것이다
  - 미로, 방, 문, 벽 등 클래스 이름을 하드코딩해놨기 때문에 서로 다른 구성요소를 가지고 미로를 만들어 내기 힘들다
  
### 생성 패턴 종류
 - [추상 팩토리 (Abstract Factory)](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter03/abstractfactory)
 - [빌더 (Builder)](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter03/builder)
 - [팩토리 메서드 (Factory Method)](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter03/factorymethod)
 - [원형 (Prototype)](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter03/prototype)
 - [단일체 (Singleton)](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter03/singleton)
