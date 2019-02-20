## 추상 팩토리 (Abstract Factory)

### 목적
상세화된 서브클래스를 정의하지 않고도 서로 관련성이 있거나 독립적인 여러 객체의 군을 생성하기 위한 인터페이스를 제공

### 활용
- 객체가 생성되거나 구성/표현되는 방식과 무관하게 시스템을 독립적으로 만들고자 할 때
- 여러 제품군 중 하나를 선택해서 시스템을 설정해야 하고 한번 구성한 제품을 다른 것으로 대체할 수 있을 때
- 관련된 제품 객체들이 함께 사용되도록 설계되었고, 이 부분에 대한 제약이 외부에도 지켜지도록 하고 싶을 때
- 제품에 대한 클래스 라이브러리를 제공하고, 그들의 구현이 아닌 인터페이스를 노출시키고 싶을 때

### 이점
- 구체적인 클래스를 분리한다: 팩토리는 제품 객체를 생성하는 과정과 책임을 캡슐화한 것이기 때문에, 구체적인 제품 클래스가 사용자에게서 분리된다 (제품 클래스 이름이 사용자 코드에는 나타나지 않는다)
- 제품군을 쉽게 대체할 수 있도록 한다: 추상 팩토리는 필요한 모든 제품을 생성하기 때문에 응용프로그램은 사용할 구체 팩토리를 교체하여 전체 제품군을 한번에 변경할 수 있다
- 제품 사이의 일관성을 증진시킨다: 하나의 제품군 안에 속한 제품 객체들이 함께 동작하도록 설계되어 있을 때, 추상 팩토리를 사용하여 프로그램 일관성을 쉽게 보장할 수 있다

### 단점
- 새로운 종류의 제품을 제공하기 어렵다: 제품 클래스가 바뀔때 마다 팩토리의 구현을 변경해야 한다

### 구현
1. 팩토리를 단일체(Singleton)로 정의: 한 제품군에 대해서 하나의 구체 팩토리 인스턴스만 있으면 되므로 단일체(Singleton)로 구현하는 것이 바람직하다
2. 제품 생성: AbstractFactory는 제품을 생성하기 위한 인터페이스를 선언하는 것이고, 각 제품을 생성하기 위한 팩토리 메서드를 재정의하여 각 제품의 인스턴스를 만든다
3. 확장 가능한 팩토리들을 정의: AbstractFactory에는 생성할 각 제품의 종류별로 서로 다른 연산(makeMaze(), makeWall() 등)을 정의한다

### 예제코드
- [AbstractFactory 인터페이스 코드](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter03/abstractfactory/MazeFactory.java)
```
public interface MazeFactory {
    public Maze makeMaze();
    public Wall makeWall();
    public Room makeRoom(int n);
    public Door makeDoor(Room r1, Room r2);
}
```

- [구체 팩토리 코드](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/main/java/chapter03/abstractfactory/EnchantedMazeFactory.java)
```
public class EnchantedMazeFactory implements MazeFactory {
    // ...
    @Override
    public Maze makeMaze() {
        return new Maze();
    }

    @Override
    public Wall makeWall() {
        return new Wall();
    }

    @Override
    public Room makeRoom(int n) {
        return new EnchantedRoom(n);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new DoorNeedingSpell(r1, r2);
    }
}
```
- [호출 테스트 코드](https://github.com/Hyunhoo-Kwon/DesignPatterens/blob/master/src/test/java/chapter03/abstractfactory/MazeGameTest.java)
```
@Test
public void createEnchantedMaze() {
    MazeFactory factory = new EnchantedMazeFactory();
    Maze maze = mazeGame.createMaze(factory);
}
```
