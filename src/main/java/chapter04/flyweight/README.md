## 플라이급 (Flyweight)

### 목적
공유를 통해 많은 수의 소립(fine-gained) 객체들을 효과적으로 지원

### 동기
수 많은 객체를 생성하고 사용하는 환경에서는 엄청난 양의 메모리와 실행 시간이 야기된다. 이를 해결하기 위해 공통적으로 사용하는 객체를 공유 풀에 담고, 이를 참조하는 형태로 사용한다

### 이점
- 재사용되는 객체의 공간을 절약할 수 있다
- 일반 상태와 부가 상태를 함께 혼용하여 사용할 수 있다

### 단점
- 객체의 인스턴스 개수는 많지 않거나, 각각의 인스턴스의 변화가 클 때 이점이 반감된다

### 구조
- Flyweight: Flyweight가 받아들일 수 있고 부가적 상태에서 동작하는 인터페이스를 선언
- ConcreteFlyweight: Flyweight 인터페이스를 구현하고 내부적으로 갖고 있어야 하는 상태에 대한 저장소를 정의
- UnsharedConcreteFlyweight: Flyweight는 공유 가능하긴 하지만, 그것을 강요해서는 안된다. 그렇기에 공유되지 않는 객체를 포함한 모든 Flyweight를 정의
- FlyweightFactory: Flyweight 객체를 생성하고 관리 및 제대로 공유되도록 보장
- Client: Flyweight 객체에 대한 참조자를 관리, Flyweight의 부가적 상태를 저장

### 참고

- https://www.dofactory.com/javascript/flyweight-design-pattern
- https://dzone.com/articles/design-patterns-in-the-real-world-flyweight
