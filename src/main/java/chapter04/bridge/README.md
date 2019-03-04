## 적응자 (Adapter)

### 목적
구현에서 추상을 분리하여, 이들이 독립적으로 다양성을 가질 수 있도록 합니다

### 동기
- 하나의 추상적 개념이 여러 가지 구현으로 구체화될 수 있을 때, 단순 상속으로는 추상적 개념과 구현을 분리해서 재사용하거나 수정/확장하기 쉽지 않다

### 활용
- 추상적 개념과 이에 대한 구현 사이의 지속적인 종속 관계를 피하고 싶을 때 (런타임에 구현 방법을 선택)
- 추상적 개념과 구현 모두가 독립적으로 서브클래싱을 통해 확장되어야 할 때
- 추상적 개념에 대한 구현 내용을 변경하는 것이 다른 관련 프로그램에 아무런 영향을 주지 않아야 할 때
- 중첩된 일반화: 클래스 계통에서 클래스 수가 급증하는 것을 방지하고자 할 때

### 이점
- 인터페이스와 구현 분리: 추상적 개념에 대해 어떤 방식의 구현을 택할지 런타임에 결정/변경할 수 있다
- 확장성: Abstraction과 Implementor를 독립적으로 확장할 수 있고, 상위 수준의 영역에서는 Abstraction과 Implementor만 알면 된다
- 상세한 구현 내용을 사용자에게서 은닉할 수 있다

### 구조
- Abstraction: 추상적 개념에 대한 인터페이스를 제공하고 객체 구현자(Implementor)에 대한 참조자를 관리
- RefinedAbstraction: 추상적 개념에 정의된 인터페이스를 확장
- Implementor: 구현 클래스에 대한 인터페이스 제공
- ConcreteImplementor: Implementor 구현체

### 구현 (Ref. https://zetawiki.com/wiki/Bridge_%ED%8C%A8%ED%84%B4)


### 참고
- [Java Bridge pattern](https://zetawiki.com/wiki/Bridge_%ED%8C%A8%ED%84%B4)
- [Python Bridge pattern](https://www.giacomodebidda.com/bridge-pattern-in-python/)
