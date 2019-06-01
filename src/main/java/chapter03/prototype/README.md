## 원형 (Prototype)

### 목적
원형이 되는(prototypical) 인스턴스를 사용하여 생성할 객체의 종류를 명시하고, 이렇게 만든 견본을 복사해서 새로운 객체를 생성

### 동기
- [The maze problem](https://github.com/Hyunhoo-Kwon/DesignPatterens/tree/master/src/main/java/chapter03#the-maze-problem): 기존 미로가 갖고 있는 레이아웃을 재사용하면서 마법의 미로 게임을 만드는 방법은? 어떻게 하면 createMaze() 함수를 쉽게 바꿔 새로운 타입의 미로를 만들 수 있을까?

### 활용
- 제품의 생성, 복합, 표현 방법에 독립적인 제품을 만들고자 할 때
- 제품 클래스 계통과 병렬적으로 만드는 팩토리 클래스를 피하고 싶을 때
- 클래스의 인스턴스들이 서로 다른 상태 조합 중에 어느 하나일 때
 
### 예제코드
[복사 생성자/복사 팩토리]
```
public class Door extends MapSite {
    private Room room1;
    private Room room2;
    
    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
    }

    // 복사 생성자
    public Door(Door other) {
        this.room1 = other.room1;
        this.room2 = other.room2;
    }

    // 복사 팩토리
    public static Door newInstance(Door other) {
        return new Door(other.room1, other.room2);
    }
}
```

### 이점
- object 생성에 높은 비용이 사용되는 경우 (DB에서 데이터를 가져오는 등) 원형 객체를 복사하여 비용을 줄일 수 있다
- 다른 생성패턴에 비해 클래스 수를 줄일 수 있다

### 단점
- 모든 제품에 clone 메서드 구현
- clone 메서드 구현시 주의사항
    - 언어에서 제공하는 복제 기능 사용 시 얕은 복사(shallow copy) 대 깊은 복사(deep copy) 문제 발생 가능
    - (JAVA 등 일부 언어) 언어에서 제공하는 복제 기능 대신 복사 생성자 혹은 복사 팩토리 사용 권장

### 활용 case
- 고객정보 수정화면: DB에 저장된 고객정보를 조회한 뒤 고객정보 수정
  - 요구사항: 최종 수정 전에 기존 고객정보와 수정 후 고객정보를 화면에 같이 보여준다
> 수정 전, 수정 후 고객정보가 필요하므로 두 개의 객체가 필요하다. DB를 여러번 조회해서 객체를 생성하는 것보다 객체를 복사해서 사용하는 방법이 효과적이다


### 참고
- [Python Design Patterns Tutorial - Prototype](https://www.tutorialspoint.com/python_design_patterns/python_design_patterns_prototype.htm)
- [Java Prototype Pattern](https://blog.seotory.com/post/2015/09/java-prototype-pattern)
